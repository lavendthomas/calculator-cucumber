package visitor;

import calculator.Operation;

import java.util.ArrayList;

public class InfixPrinter extends Printer{

    @Override
    protected String writeExpression(Operation o, ArrayList<String> strings, int counter) {
        return "( " + strings.get(counter-1) + " " + o.getSymbol() + " " + strings.get(counter) + " )";
    }
}
