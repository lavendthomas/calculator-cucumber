package calculator.operation.buildinfunctions;

import calculator.Expression;
import calculator.Real;
import ch.obermuhlner.math.big.BigDecimalMath;

public class Asin extends RealFunction {
    public Asin(Expression e) {
        super("asin", e);
    }

    @Override
    public Real op(Real l) {
        return new Real(BigDecimalMath.asin(l.getValue(), mc));
    }
}
