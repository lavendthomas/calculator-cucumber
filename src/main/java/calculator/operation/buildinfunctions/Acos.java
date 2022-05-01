package calculator.operation.buildinfunctions;

import calculator.Expression;
import calculator.Real;
import ch.obermuhlner.math.big.BigDecimalMath;

public class Acos extends RealFunction{

    public Acos(Expression e) {
        super("acos", e);
    }

    @Override
    public Real op(Real l) {
        return new Real(BigDecimalMath.acos(l.getValue(), mc));
    }
}
