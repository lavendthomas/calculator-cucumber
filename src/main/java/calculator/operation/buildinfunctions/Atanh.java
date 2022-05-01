package calculator.operation.buildinfunctions;

import calculator.Expression;
import calculator.Real;
import ch.obermuhlner.math.big.BigDecimalMath;

public class Atanh extends RealFunction {

    public Atanh(Expression e) {
        super("atanh", e);
    }

    @Override
    public Real op(Real l) {
        return new Real(BigDecimalMath.atanh(l.getValue(), mc));
    }
}
