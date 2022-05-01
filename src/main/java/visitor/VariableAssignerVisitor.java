package visitor;

import calculator.*;
import calculator.Number;
import calculator.operation.buildinfunctions.RealFunction;

public class VariableAssignerVisitor extends Visitor{

    Expression value;

    public VariableAssignerVisitor(Expression value) {
        this.value = value;
    }

    @Override
    public void visit(Number n) {
        // Nothing to do here
    }

    @Override
    public void visit(Variable v) {
        v.assignValue(value);
    }

    @Override
    public void visit(Operation o) {
        // Visit all children to assign the value everywhere
        for (Expression e: o.args) {
            e.accept(this);
        }
    }

    @Override
    public void visit(MyBoolean b) {

    }

    @Override
    public void visit(RealFunction f) {
        f.getExpr().accept(this);
    }
}
