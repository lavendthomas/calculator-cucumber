package visitor;

import calculator.Expression;
import calculator.IllegalArithmeticOperation;
import calculator.MyNumber;
import calculator.Operation;

import java.util.ArrayList;
import java.util.Optional;

public class Evaluator extends Visitor {

    private int computedValue;
    private boolean isSuccessfulVisit;

    public Optional<Integer> getResult() {
        if (isSuccessfulVisit) {
            return Optional.of(computedValue);
        } else {
            return Optional.empty();
        }
    }

    public void visit(MyNumber n) {
        computedValue = n.getValue().get();
        isSuccessfulVisit = true;
    }

    public void visit(Operation o) {
        ArrayList<Integer> evaluatedArgs = new ArrayList<>();
        //first loop to recursively evaluate each subexpression
        for(Expression a:o.args) {
            a.accept(this);
            evaluatedArgs.add(computedValue);
        }
        //second loop to accummulate all the evaluated subresults
        int temp = evaluatedArgs.get(0);
        int max = evaluatedArgs.size();
        isSuccessfulVisit = true;
        for(int counter=1; counter<max; counter++) {
            try {
                temp = o.op(temp,evaluatedArgs.get(counter));
            } catch (IllegalArithmeticOperation e) {
                // handle errors such as division by zero
                isSuccessfulVisit = false;
                break;
            }

        }
        // store the accumulated result
        computedValue = temp;
    }

}
