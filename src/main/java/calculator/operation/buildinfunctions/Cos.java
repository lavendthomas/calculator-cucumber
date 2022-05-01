package calculator.operation.buildinfunctions;

import calculator.Expression;
import calculator.Real;
import ch.obermuhlner.math.big.BigDecimalMath;

public class Cos extends RealFunction {

    public Cos(Expression e) {
        super("cos", e);
    }

    @Override
    public Real op(Real l) {
        return new Real(BigDecimalMath.cos(l.getValue(), mc));
    }
}
