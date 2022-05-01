package calculator.operation;

import calculator.*;
import calculator.Number;

import java.util.List;

public class LogicalEquivalence extends Operation {



    public LogicalEquivalence(List<Expression> elist) throws IllegalConstruction {
        super(elist);
        symbol = "<==>";
    }

    @Override
    public Number op(Number l, Number r) {
        return null;
    }


    @Override
    public MyBoolean op(MyBoolean a, MyBoolean b) {
        return new MyBoolean((!a.getValue() || b.getValue()) && (!b.getValue() || a.getValue()));
    }

    @Override
    public MyBoolean op(MyBoolean a) {
        return new MyBoolean(false);
    }
}
