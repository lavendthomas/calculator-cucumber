package visitor;

import calculator.*;
import calculator.Number;
import calculator.operation.buildinfunctions.RealFunction;

import java.util.ArrayList;

public class Evaluator extends Visitor {

    private Number computedValue;
    private MyBoolean computedBoolValue;

    public Number getResult() { return computedValue; }
    public MyBoolean getBoolResult(){return computedBoolValue;}

    public void visit(Number n) {
        computedValue = n;
    }

    @Override
    public void visit(Variable v) {
        if (!v.hasValue()) {
            throw new RuntimeException("Variable has not been assigned");
        }
        v.accept(this);
        //TODO store computer value
        //computedValue = ;
    }

    public void visit(Operation o) {
        ArrayList<Number> evaluatedArgs = new ArrayList<>();
        ArrayList<MyBoolean> evaluatedBoolArgs = new ArrayList<>();
        //first loop to recursively evaluate each subexpression
        for(Expression a:o.args) {
            a.accept(this);
            evaluatedArgs.add(computedValue);
            evaluatedBoolArgs.add(computedBoolValue);
        }
        //second loop to accumulate all the evaluated subresults
        Number temp = evaluatedArgs.get(0);
        int max = evaluatedArgs.size();
        for(int counter=1; counter<max; counter++) {
            temp = o.op(temp,evaluatedArgs.get(counter));
        }
        // store the accumulated result
        computedValue = temp;

        MyBoolean boolTemp = evaluatedBoolArgs.get(0);
        int maxInd = evaluatedBoolArgs.size();
        for (int cpt=1; cpt<maxInd; cpt++){
            boolTemp = o.op(boolTemp,evaluatedBoolArgs.get(cpt));
        }

        computedBoolValue = boolTemp;
    }

    @Override
    public void visit(MyBoolean myBoolean) {
        computedBoolValue = myBoolean;
    }

    public void visit(RealFunction f) {
        // Evaluate the expression
        f.getExpr().accept(this);

        Real argument = getResult().toReal(); // Assume for now that all functions are on reals
        // store the accumulated result
        computedValue = f.op(argument); // compute the result
    }

}
