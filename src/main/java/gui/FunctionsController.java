package gui;

import calculator.Calculator;
import calculator.Expression;
import calculator.Parser;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

import java.util.List;

import static gui.navigation.ModeEnum.FUNCTION_MODE;

/**
 * Controller for the functions view.
 */
public class FunctionsController extends ControllerWithMemory {
    @FXML
    public Pane pane;

    private Calculator calculator;
    private Parser parser;
    private double xCenter = 0;
    private double yCenter = 0;
    private double pixelSize = 0.05;
    private final List<String> acceptedFunctions = List.of("abs", "acos", "acosh", "asin", "asinh", "atan", "atanh", "cbrt", "cos", "cosh", "exp", "ln", "log", "sin", "sinh", "sqrt", "tan", "tanh");

    public void initialize() {
        calculator = new Calculator();
        parser = new Parser(calculator);
    }

    public void submitButton() {
        String function = inputField.getText();
        if (function.isEmpty()) {
            showAlertMessage("Please enter a function");
        } else if (!function.contains("x")) {
            showAlertMessage("Please enter a function with x");
        } else if (!acceptedFunctions.contains(function.split("\\(")[0]) && !function.contains("^")) {
            showAlertMessage("Please enter a valid function");
        } else {
            drawFunction();
        }
        keepComponentValue(inputField.getText(), "[graphical result]", FUNCTION_MODE.id());
    }

    public void up() {
        yCenter += (5. * pixelSize);
        drawFunction();
    }

    public void down() {
        yCenter -= (5. * pixelSize);
        drawFunction();
    }

    public void left() {
        xCenter -= (5. * pixelSize);
        drawFunction();
    }

    public void right() {
        xCenter += (5. * pixelSize);
        drawFunction();
    }

    public void zoomIn() {
        pixelSize -= 0.01;
        if (pixelSize < 0.01) pixelSize = 0.01;
        drawFunction();
    }

    public void zoomOut() {
        pixelSize += 0.01;
        drawFunction();
    }

    public void cancel() {
        pane.getChildren().clear();
        inputField.clear();
    }

    private void drawFunction() {
        pane.getChildren().clear();
        Path path = new Path();
        path.setStrokeWidth(1);
        path.setStroke(Color.GREEN);
        String function = inputField.getText();

        double xCenterPixel = (pane.getWidth()/2)-(xCenter/pixelSize);
        double yCenterPixel = (pane.getHeight()/2)-(yCenter/pixelSize);

        Line axisX = new Line(0, yCenterPixel, pane.getWidth(), yCenterPixel);
        Line axisY = new Line(xCenterPixel, 0, xCenterPixel, pane.getHeight());

        pane.getChildren().addAll(axisX, axisY);

        boolean isFirstPoint = true;

        for(int x = 0 ; x < (int) (pane.getWidth()) ; x++) {
            double xValue = pixelToDouble(x, xCenter) - (xCenterPixel*pixelSize);

            try {
                Expression expression = parser.parse(function.replace("x", Double.toString(xValue)));
                double yValue = calculator.eval(expression).toReal().getValue().doubleValue();
                int y = (int) (yCenterPixel + doubleToPixel(yValue + yCenter));
                if (isFirstPoint) {
                    path.getElements().add(new MoveTo(x, y));
                    isFirstPoint = false;
                } else {
                    path.getElements().add(new LineTo(x, y));
                }
            } catch (Exception ignored) { }
        }
        pane.getChildren().add(path);
    }

    private double pixelToDouble(int pixel, double center) {
        return center + (pixel * pixelSize);
    }

    private int doubleToPixel(double value) {
        return -(int) (value / pixelSize);
    }

}