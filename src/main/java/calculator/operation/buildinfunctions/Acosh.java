package calculator.operation.buildinfunctions;

import calculator.Expression;
import calculator.Real;
import ch.obermuhlner.math.big.BigDecimalMath;

public class Acosh extends RealFunction {

    public Acosh(Expression e) {
        super("acosh", e);
    }

    @Override
    public Real op(Real l) {
        return new Real(BigDecimalMath.acosh(l.getValue(), mc));
    }
}
