package calculator.operation.buildinfunctions;

import calculator.Expression;
import calculator.Real;
import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;

public class Cbrt extends RealFunction {

    public Cbrt(Expression e) {
        super("cbrt", e);
    }

    @Override
    public Real op(Real l) {
        return new Real(BigDecimalMath.root(l.getValue(), BigDecimal.valueOf(3), mc));
    }
}
