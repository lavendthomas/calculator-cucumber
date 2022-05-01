package calculator.operation.buildinfunctions;

import calculator.Expression;
import calculator.Real;
import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;

public class Abs extends RealFunction {

    public Abs(Expression e) {
        super("abs", e);
    }

    @Override
    public Real op(Real l) {
        return new Real(l.getValue().abs());
    }
}
