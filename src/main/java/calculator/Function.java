package calculator;

import calculator.operation.buildinfunctions.RealFunction;
import visitor.InfixPrinter;
import visitor.Printer;
import visitor.Visitor;


public class Function implements Expression
{
    protected Expression expression;
    protected String name;

    public /*constructor*/ Function(String name, Expression expression) {
        this.name = name;
        this.expression = expression;
    }

    public final String getName() {
        return name;
    }

    public final Expression getExpr() {
        return expression;
    }

    public final void changeExpression(Expression expression) {
        this.expression = expression;
    }

//    abstract public Real op(Real l);
//    // the operation itself is specified in the subclasses

    public void accept(Visitor v) {
        // ask each of the argument expressions of the current operation to accept the visitor
        expression.accept(v);
    }

    final public Integer countDepth() {
        // use of Java 8 functional programming capabilities
        return 1 + expression.countDepth();
    }

    final public Integer countOps() {
        // use of Java 8 functional programming capabilities
        return 1 + expression.countOps();
    }

    final public Integer countNbs() {
        // use of Java 8 functional programming capabilities
        return expression.countNbs();
    }

    @Override
    final public String toString() {
//        Printer p = new InfixPrinter();
        return name; // + "(" + toString(p) + ")";
    }

    final public String toString(Printer p) {
        p.visit((RealFunction) this); // TODO casting will fail
        return p.getBuffer();
    }

    //Two Operation expressions are equal if their list of arguments is equal and they are the same operation
    @Override
    public boolean equals(Object o) {
        if (o == null) return false; // No object should be equal to null

        if (this == o) return true; // If it's the same object, they're obviously equal

        if (getClass() != o.getClass()) return false; // getClass() instead of instanceof() because an addition is not the same as a multiplication

        Function other = (Function) o;
        return this.expression.equals(other.expression);
    }

    // The method hashCode also needs to be overridden it the equals method is overridden; otherwise there may be problems when you use your object in hashed collections such as HashMap, HashSet, LinkedHashSet
    @Override
    public int hashCode()
    {
        int result = 5, prime = 31;
        result = prime * result + name.hashCode();
        result = prime * result + expression.hashCode();
        return result;
    }

}
