package visitor;

import calculator.*;
import calculator.Number;
import calculator.operation.buildinfunctions.RealFunction;

import javax.swing.plaf.metal.MetalBorders;

/* Visitor design pattern
 */
public abstract class Visitor {

    public abstract void visit(Number n);
    public abstract void visit(Variable v);
    public abstract void visit(RealFunction f);
    public abstract void visit(Operation o);
    public abstract void visit(MyBoolean b);
}
