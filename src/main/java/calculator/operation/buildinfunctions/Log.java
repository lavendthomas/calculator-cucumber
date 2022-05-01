package calculator.operation.buildinfunctions;

import calculator.Expression;
import calculator.Real;
import ch.obermuhlner.math.big.BigDecimalMath;

public class Log extends RealFunction {

    public Log(Expression e) {
        super("log", e);
    }

    @Override
    public Real op(Real l) {
        return new Real(BigDecimalMath.log10(l.getValue(), mc));
    }
}
