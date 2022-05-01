package calculator;

import visitor.Evaluator;
import visitor.Visitor;

public class Variable implements Expression {

    private final String name;
    private Expression assignment;

    public Variable(String name) {
        this.name = name;
    }

    public void assignValue(Expression val) {
        this.assignment = val;
    }

    public boolean hasValue() {
        return assignment != null;
    }

    @Override
    public void accept(Visitor v) {
        if (assignment != null) {
            assignment.accept(v);
        }
        if (v instanceof Evaluator && assignment != null) return; // TODO remove
        v.visit(this);


    }

    @Override
    public Integer countDepth() {
        return assignment == null ? 0 : assignment.countDepth();
    }

    @Override
    public Integer countOps() {
        return assignment == null ? 0 : assignment.countOps();
    }

    @Override
    public Integer countNbs() {
        return assignment == null ? 0 : assignment.countNbs();
    }

    @Override
    public String toString() {
        return name;
    }
}
