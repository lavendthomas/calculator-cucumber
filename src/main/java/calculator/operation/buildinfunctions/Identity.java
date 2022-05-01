package calculator.operation.buildinfunctions;

import calculator.Expression;
import calculator.IllegalConstruction;
import calculator.Real;

import java.util.List;


public class Identity extends RealFunction {

    public Identity(Expression e) throws IllegalConstruction {
        super("identity", e);
    }

    @Override
    public Real op(Real l) {
        return l;
    }
}
