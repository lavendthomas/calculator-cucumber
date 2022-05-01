package calculator.operation.buildinfunctions;

import calculator.Expression;
import calculator.Real;
import ch.obermuhlner.math.big.BigDecimalMath;

public class Cosh extends RealFunction {

    public Cosh(Expression e) {
        super("cosh", e);
    }

    @Override
    public Real op(Real l) {
        return new Real(BigDecimalMath.cosh(l.getValue(), mc));
    }
}
