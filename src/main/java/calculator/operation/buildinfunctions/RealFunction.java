package calculator.operation.buildinfunctions;

import calculator.*;
import visitor.Visitor;

import java.math.MathContext;


public abstract class RealFunction extends Function {

    protected MathContext mc = MathContext.DECIMAL128;

    public RealFunction(String name, Expression expression) {
        super(name, expression);
    }

    @Override
    public void accept(Visitor v) {
        // ask each of the argument expressions of the current operation to accept the visitor
        expression.accept(v);

        // Evaluate the function
        v.visit(this);
    }

    public abstract Real op(Real l);

}
