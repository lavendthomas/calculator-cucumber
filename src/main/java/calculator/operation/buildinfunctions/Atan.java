package calculator.operation.buildinfunctions;

import calculator.Expression;
import calculator.Real;
import ch.obermuhlner.math.big.BigDecimalMath;

public class Atan extends RealFunction {

    public Atan(Expression e) {
        super("atan", e);
    }

    @Override
    public Real op(Real l) {
        return new Real(BigDecimalMath.atan(l.getValue(), mc));
    }
}
