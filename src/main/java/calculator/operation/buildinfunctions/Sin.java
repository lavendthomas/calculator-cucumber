package calculator.operation.buildinfunctions;

import calculator.Expression;
import calculator.Real;
import ch.obermuhlner.math.big.BigDecimalMath;

public class Sin extends RealFunction{

    public Sin(Expression e) {
        super("sin", e);
    }

    @Override
    public Real op(Real l) {
        return new Real(BigDecimalMath.sin(l.getValue(), mc));
    }
}
