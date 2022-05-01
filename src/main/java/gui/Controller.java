package gui;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class Controller  {
    private Scene sceneBasic;
    private Scene sceneConverter;
    private Scene sceneScientific;
    private Scene sceneFunctions;
    protected Stage stage;

    private boolean submitted;

    @FXML
    public VBox mainScreen;
    public MenuBar bar;
    public TextField inputField;
    public TextField outputField;

    public void setSceneBasic(Scene sceneBasic) {
        this.sceneBasic = sceneBasic;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setSceneConverter(Scene sceneConverter) {
        this.sceneConverter = sceneConverter;
    }

    public void setSceneScientific(Scene sceneScientific) {
        this.sceneScientific = sceneScientific;
    }

    public void setSceneFunctions(Scene sceneFunctions) {
        this.sceneFunctions = sceneFunctions;
    }

    public void cancelButton() {
        setSubmitted(false);
        inputField.setText("");
        outputField.setText("");
    }

    public void eraseButton() {
        clearAfterSubmitted();
        String current = inputField.getText();
        if (!current.isEmpty()) {
            inputField.setText(current.substring(0, current.length()-1));
        }
    }

    public void clickValueButton(Event e) {
        clearAfterSubmitted();
        String val = ((Button) e.getSource()).getText();
        inputField.setText(inputField.getText() + val);
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public void clearAfterSubmitted() {
        if (isSubmitted()) {
            setSubmitted(false);
            resetFields();
        }
    }

    @FXML
    public void showSceneBasic() {
        resetFields();
        Stage stage = (Stage) mainScreen.getScene().getWindow();
        stage.setScene(sceneBasic);
    }

    @FXML
    public void showSceneConverter() {
        resetFields();
        Stage stage = (Stage) mainScreen.getScene().getWindow();
        stage.setScene(sceneConverter);
    }

    @FXML
    public void showSceneScientific() {
        resetFields();
        Stage stage = (Stage) mainScreen.getScene().getWindow();
        stage.setScene(sceneScientific);
    }

    @FXML
    public void showSceneFunctions() {
        resetFields();
        Stage stage = (Stage) mainScreen.getScene().getWindow();
        stage.setScene(sceneFunctions);
    }

    private void resetFields() {
        inputField.setText("");
        if (outputField != null) outputField.setText("");
    }
    public void showAlertMessage(String message) {
        inputField.setText(inputField.getText() + " !! " + message);
    }

    public abstract void submitButton();
}
