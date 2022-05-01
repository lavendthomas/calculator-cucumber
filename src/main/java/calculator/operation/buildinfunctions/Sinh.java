package calculator.operation.buildinfunctions;

import calculator.Expression;
import calculator.Real;
import ch.obermuhlner.math.big.BigDecimalMath;

public class Sinh extends RealFunction {

    public Sinh(Expression e) {
        super("sinh", e);
    }

    @Override
    public Real op(Real l) {
        return new Real(BigDecimalMath.sinh(l.getValue(), mc));
    }
}
