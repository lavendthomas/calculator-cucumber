package visitor;

import calculator.Function;
import calculator.Operation;

import java.util.ArrayList;

public class InfixPrinter extends Printer {

    @Override
    protected String writeExpression(Operation o, ArrayList<String> strings, int counter) {
        return "( " + strings.get(counter-1) + " " + o.getSymbol() + " " + strings.get(counter) + " )";
    }

    @Override
    protected String writeExpression(Function f, ArrayList<String> strings) {
        return "(" + strings.get(0) + ", " + strings.get(0) + ") " + f.getName(); // TODO

    }
}