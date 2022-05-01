package calculator.operation.buildinfunctions;

import calculator.Expression;
import calculator.Real;
import ch.obermuhlner.math.big.BigDecimalMath;

public class Exp extends RealFunction{

    public Exp(Expression e) {
        super("exp", e);
    }

    @Override
    public Real op(Real l) {
        return new Real(BigDecimalMath.exp(l.getValue(), mc));
    }
}
