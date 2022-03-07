package visitor;

import calculator.Operation;

import java.util.ArrayList;

public class PostfixPrinter extends Printer{

    @Override
    protected String writeExpression(Operation o, ArrayList<String> strings, int counter) {
        return "(" + strings.get(counter - 1) + ", " + strings.get(counter) + ") " + o.getSymbol();
    }
}
