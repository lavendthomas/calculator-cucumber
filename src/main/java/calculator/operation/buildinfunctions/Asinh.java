package calculator.operation.buildinfunctions;

import calculator.Expression;
import calculator.Real;
import ch.obermuhlner.math.big.BigDecimalMath;

public class Asinh extends RealFunction {

    public Asinh(Expression e) {
        super("asinh", e);
    }

    @Override
    public Real op(Real l) {
        return new Real(BigDecimalMath.asinh(l.getValue(), mc));
    }
}
