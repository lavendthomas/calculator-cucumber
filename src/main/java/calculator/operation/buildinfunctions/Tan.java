package calculator.operation.buildinfunctions;

import calculator.Expression;
import calculator.Real;
import ch.obermuhlner.math.big.BigDecimalMath;

public class Tan extends RealFunction {

    public Tan(Expression e) {
        super("tan", e);
    }

    @Override
    public Real op(Real l) {
        return new Real(BigDecimalMath.tan(l.getValue(), mc));
    }
}
