package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import static common.Configuration.*;

/**
 * The GUI application Launcher
 */
public class JavaFXGUI extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Charge scene for basic calculator
        FXMLLoader loaderBasic = new FXMLLoader(getClass().getResource("/gui/layouts/basic.fxml"));
        Parent parentBasic = loaderBasic.load();
        Scene sceneBasic = new Scene(parentBasic);

        // Charge scene for converter
        FXMLLoader loaderConverter = new FXMLLoader(getClass().getResource("/gui/layouts/converter.fxml"));
        Parent parentConverter = loaderConverter.load();
        Scene sceneConverter = new Scene(parentConverter);

        // Charge scene for scientific
        FXMLLoader loaderScientific = new FXMLLoader(getClass().getResource("/gui/layouts/scientific.fxml"));
        Parent parentScientific = loaderScientific.load();
        Scene sceneScientific = new Scene(parentScientific);

        // Charge scene for functions
        FXMLLoader loaderFunctions = new FXMLLoader(getClass().getResource("/gui/layouts/functions.fxml"));
        Parent parentFunctions = loaderFunctions.load();
        Scene sceneFunctions = new Scene(parentFunctions);

        // Add controller to basic loader
        BasicController basicController = loaderBasic.getController();
        basicController.setSceneBasic(sceneBasic);
        basicController.setSceneConverter(sceneConverter);
        basicController.setSceneScientific(sceneScientific);
        basicController.setSceneFunctions(sceneFunctions);
        basicController.setStage(stage);

        // Add controller to converter loader
        ConverterController converterController = loaderConverter.getController();
        converterController.setSceneBasic(sceneBasic);
        converterController.setSceneConverter(sceneConverter);
        converterController.setSceneScientific(sceneScientific);
        converterController.setSceneFunctions(sceneFunctions);

        // Add controller to scientific loader
        ScientificController scientificController = loaderScientific.getController();
        scientificController.setSceneBasic(sceneBasic);
        scientificController.setSceneConverter(sceneConverter);
        scientificController.setSceneScientific(sceneScientific);
        scientificController.setSceneFunctions(sceneFunctions);

        // Add controller to functions loader
        FunctionsController functionsController = loaderFunctions.getController();
        functionsController.setSceneBasic(sceneBasic);
        functionsController.setSceneConverter(sceneConverter);
        functionsController.setSceneScientific(sceneScientific);
        functionsController.setSceneFunctions(sceneFunctions);

        stage.setScene(sceneBasic);
        stage.setTitle(TITLE_MAIN);
        stage.setResizable(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}