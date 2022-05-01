package calculator.operation.buildinfunctions;

import calculator.Expression;
import calculator.Real;
import ch.obermuhlner.math.big.BigDecimalMath;

public class Ln extends RealFunction {

    public Ln(Expression e) {
        super("ln", e);
    }

    @Override
    public Real op(Real l) {
        return new Real(BigDecimalMath.log(l.getValue(), mc));
    }
}
