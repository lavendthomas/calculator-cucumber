package visitor;

import calculator.Operation;

import java.util.ArrayList;

public class PrefixPrinter extends Printer {

    @Override
    protected String writeExpression(Operation o, ArrayList<String> strings, int counter) {
        return o.getSymbol() + " (" + strings.get(counter-1) + ", " + strings.get(counter) + ")";
    }
}
