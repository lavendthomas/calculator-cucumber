package calculator.operation.buildinfunctions;

import calculator.Expression;
import calculator.Real;
import ch.obermuhlner.math.big.BigDecimalMath;

public class Tanh extends RealFunction {

    public Tanh(Expression e) {
        super("tanh", e);
    }

    @Override
    public Real op(Real l) {
        return new Real(BigDecimalMath.tanh(l.getValue(), mc));
    }
}
