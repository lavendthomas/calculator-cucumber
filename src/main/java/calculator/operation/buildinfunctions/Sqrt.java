package calculator.operation.buildinfunctions;

import calculator.Expression;
import calculator.Real;
import ch.obermuhlner.math.big.BigDecimalMath;

public class Sqrt extends RealFunction {

    public Sqrt(Expression e) {
        super("sqrt", e);
    }

    @Override
    public Real op(Real l) {
        return new Real(BigDecimalMath.sqrt(l.getValue(), mc));
    }
}
