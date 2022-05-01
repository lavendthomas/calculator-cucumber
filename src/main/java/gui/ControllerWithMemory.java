package gui;

import common.UnexpectedExpressionException;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import memory.CircularLinkedList;
import memory.service.MemoriesCareTaker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import static common.Configuration.*;
import static javafx.print.Printer.getDefaultPrinter;
import static javafx.scene.control.ButtonBar.ButtonData.OK_DONE;

/**
 * This class Handle the Memory with the Controller system
 * Extends this one instead Controller to add MemoriesCareTaker functionality
 */
public abstract class ControllerWithMemory extends Controller implements MemoriesCareTaker {

    private final FileChooser fileChooser = new FileChooser();

    public ControllerWithMemory() {
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(FILE_TYPE_DESCRIPTION, FILE_TYPE)
        );
    }

    /**
     * Memory navigation button : going left
     */
    public void historyLeft(ActionEvent e) {
        navigateLeft(history().getCurrentPosition().getIndex(), getPage(e));
    }

    /**
     * Memory navigation button : going right
     */
    public void historyRight(ActionEvent e) {
        navigateRight(history().getCurrentPosition().getIndex(), getPage(e));
    }

    /**
     * Memory navigation button : going to the last processed expression
     */
    public void historyLast(ActionEvent e) {
        int currentIndex = history().getCurrentPosition().getIndex();
        navigateLast(history().navigateLast(), getPage(e), currentIndex);
    }

    /**
     * Memory navigation button : going to the oldest processed expression
     */
    public void historyFirst(ActionEvent e) {
        int currentIndex = history().getCurrentPosition().getIndex();
        navigateFirst(history().navigateFirst(), getPage(e), currentIndex);
    }

    /**
     * Open a dialog panel to save the memory status to a txt file
     */
    public void saveHistory() throws FileNotFoundException {
        saveToFile(fileChooser.showSaveDialog(stage));
    }

    /**
     * Open a dialog panel to load the memory status from a txt file
     */
    public void loadHistory() throws IOException, UnexpectedExpressionException {
        fileChooser.setInitialDirectory(new File(System.getProperty(DEFAULT_DIRECTORY)));
        loadCircularList(fileChooser.showOpenDialog(null));
    }

    /**
     * Open a dialog panel to configurate the memory size
     */
    public void configHistory() {
        long currentValue = history().getMemorySize();
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle(CONFIGURATION_TITLE);
        Slider slider = new Slider(MIN_MEM_SIZE, MAX_MEM_SIZE, currentValue);
        Label label = new Label(MEMORY_SIZE_DIALOG_TEXT);
        Label res = new Label(Long.toString(currentValue));
        ButtonType buttonOk = new ButtonType(MEMORY_SIZE_DIALOG_BUTTON);
        HBox content = new HBox(slider, label, res);

        slider.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    long val = Math.round(newValue.doubleValue());
                    res.setText(String.valueOf(val));
                    history().setMemorySize(val);
                });

        dialog.setGraphic(content);
        dialog.getDialogPane().getButtonTypes().add(buttonOk);
        dialog.show();
    }

    /**
     * Open a dialog panel to select a printer and print the memory
     */
    public void printHistory() {

        Dialog<String> dialog = new Dialog<>();
        ButtonType buttonOk = new ButtonType(PRINTER_DIALOG_BUTTON, OK_DONE);
        ListView<Printer> printerListView = new ListView<>();
        TextArea somethingToPrint = new TextArea();
        Label jobStatus = new Label();
        ObservableSet<Printer> printers = Printer.getAllPrinters();
        AtomicReference<Printer> selectedPrinter = new AtomicReference<>(getDefaultPrinter());
        String printContent = loadMemory();

        dialog.setTitle(PRINT_TITLE);
        somethingToPrint.setEditable(true);
        somethingToPrint.setText(printContent);
        printers.forEach(p -> printerListView.getItems().add(p));
        printerListView.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> selectedPrinter.set(newValue));

        HBox content = new HBox(printerListView, somethingToPrint);

        dialog.setGraphic(content);
        dialog.getDialogPane().getButtonTypes().add(buttonOk);
        dialog.setOnCloseRequest(event -> {
            if (selectedPrinter.get() == null) return;
            PrinterJob job = PrinterJob.createPrinterJob(selectedPrinter.get());
            System.out.println(PRINTER_WITH_THIS + selectedPrinter);
            jobStatus.textProperty().unbind();
            jobStatus.setText(PRINTER_INITIATE_TASK);
            jobStatus.textProperty().bind(job.jobStatusProperty().asString());
            boolean printed = job.printPage(somethingToPrint);

            if (printed)
                job.endJob();
            else {
                jobStatus.textProperty().unbind();
                jobStatus.setText(PRINTER_FAILED);
            }
        });

        dialog.show();
    }

    private void screenUpdate(CircularLinkedList item) {
        if (item == null)  return;

        if (outputField != null)
            outputField.setText(item.getDTO().getResult());

        if (inputField != null)
            inputField.setText(item.getDTO().getExpression());
    }

    private void navigateLeft(int index, String page) {
        String mode = history().navigateLeft().getDTO().getMode();
        if (page.equals(mode))
            screenUpdate(history().getCurrentPosition());
        else if (index != history().getCurrentPosition().getIndex())
            navigateLeft(index, page);
    }

    private void navigateRight(int index, String page) {
        String mode = history().navigateRight().getDTO().getMode();
        if (page.equals(mode))
            screenUpdate(history().getCurrentPosition());
        else if (index != history().getCurrentPosition().getIndex())
            navigateRight(index, page);
    }

    private String getPage(ActionEvent e) {
        Button source = (Button) e.getSource();
        return source.getParent().getId();
    }

    private void navigateLast(CircularLinkedList currentItem, String page, int startIndex) {
        if (page.equals(currentItem.getDTO().getMode()))
            screenUpdate(history().getCurrentPosition());
        else if (startIndex != history().getCurrentPosition().getIndex())
            navigateLast(history().navigateRight(), page, startIndex);
    }

    private void navigateFirst(CircularLinkedList currentItem, String page, int startIndex) {
        if (page.equals(currentItem.getDTO().getMode()))
            screenUpdate(history().getCurrentPosition());
        else if (startIndex != history().getCurrentPosition().getIndex())
            navigateFirst(history().navigateLeft(), page, startIndex);
    }
}
