package gui;

import calculator.Calculator;
import calculator.Expression;
import calculator.Integ;
import calculator.Parser;
import ch.obermuhlner.math.big.BigDecimalMath;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.math.BigInteger;
import java.math.MathContext;

import static gui.navigation.ModeEnum.SCIENTIFIC_MODE;
import static java.math.MathContext.DECIMAL128;

public class ScientificController extends ControllerWithMemory {

    private final Calculator calculator = new Calculator();
    private final Parser parser = new Parser(calculator);
    public HBox ScientificMode;
    protected MathContext mc = DECIMAL128;

    @Override
    public void submitButton() {
        String input = inputField.getText();

            if (input.contains("PGCD")) {
                if (!input.contains(")")) {
                    input = input + ")";
                }
                try {
                    var temp = input.substring(input.indexOf("(") + 1, input.indexOf(")"));
                    var temp2 = temp.split("\\.");
                    Integ val1 = new Integ(new BigInteger(temp2[0]));
                    var result = val1.gcd(new Integ(new BigInteger(temp2[1]))).toString();
                    this.outputField.setText(result);
                    keepComponentValue(inputField.getText(), result, SCIENTIFIC_MODE.id());
                } catch (Exception e) {
                    this.showAlertMessage(e.getMessage());
                }
            } else if (input.contains("MOD")) {
                try {
                    if (!input.contains(")")) {
                        input = input + ")";
                    }
                    var temp = input.substring(input.indexOf("(") + 1, input.indexOf(")"));
                    var temp2 = temp.split("\\.");
                    Integ val1 = new Integ(new BigInteger(temp2[0]));
                    var result = val1.modulo(new Integ(new BigInteger(temp2[1]))).toString();
                    this.outputField.setText(result);
                    keepComponentValue(inputField.getText(), result, SCIENTIFIC_MODE.id());
                } catch (Exception e) {
                    this.showAlertMessage(e.getMessage());
                }
            } else {
                input = input.replace("є", BigDecimalMath.e(mc).toString());
                input = input.replace("π", BigDecimalMath.pi(mc).toString());
                input = input.replace("√", "sqrt");
                input = input.replace("∛", "cbrt");
                input = input.replace("%", "/100");

                try {
                    Expression expr = parser.parse(input);
                    String result = input.contains(":=") ? "function stored" : calculator.eval(expr).toString();
                    this.outputField.setText(result);
                    keepComponentValue(inputField.getText(), result, SCIENTIFIC_MODE.id());
                } catch (Exception e) {
                    this.showAlertMessage(e.getMessage());
                }
            }
        this.setSubmitted(true);
    }

    public void plusButton() {
        clearAfterSubmitted();
        inputField.setText(inputField.getText() + "+");
    }

    public void minusButton() {
        clearAfterSubmitted();
        inputField.setText(inputField.getText() + "-");
    }

    public void timesButton() {
        clearAfterSubmitted();
        inputField.setText(inputField.getText() + "×");
    }

    public void dividesButton() {
        clearAfterSubmitted();
        inputField.setText(inputField.getText() + "/");
    }

    public void clickFctButton(Event event) {
        clearAfterSubmitted();
        inputField.setText(inputField.getText() + ((Button)event.getSource()).getText() + "(");
    }

    public void clickAbsButton() {
        clearAfterSubmitted();
        inputField.setText(inputField.getText() + "abs(");
    }

    public void clickInverseButton() {
        clearAfterSubmitted();
        String input = inputField.getText();
        if (input.length() > 0) {
            if (input.contains("/")) {
                inputField.setText(input.substring(input.indexOf("/") + 1) + "/" + input.substring(0, input.indexOf("/")));
            } else {
                inputField.setText("1/" + input);
            }
        }
    }

    public void clickSquareButton() {
        clearAfterSubmitted();
        inputField.setText(inputField.getText() + "^2");
    }

    public void clickCubicButton() {
        clearAfterSubmitted();
        inputField.setText(inputField.getText() + "^3");
    }

    public void mod() {
        clearAfterSubmitted();
        inputField.setText(inputField.getText() + "MOD(");
    }

    public void pgcd() {
        clearAfterSubmitted();
        inputField.setText(inputField.getText() + "PGCD(");
    }
}
