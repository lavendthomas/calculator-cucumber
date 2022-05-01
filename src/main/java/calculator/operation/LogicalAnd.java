package calculator.operation;

import calculator.*;
import calculator.Number;

import java.util.List;

public class LogicalAnd extends Operation {

    public LogicalAnd(List<Expression> elist) throws IllegalConstruction {
        super(elist);
        symbol = "AND";
    }

    @Override
    public Number op(Number l, Number r) {
        return null;
    }

    @Override
    public MyBoolean op(MyBoolean a, MyBoolean b) {
        return new MyBoolean(a.getValue() && b.getValue());
    }

    @Override
    public MyBoolean op(MyBoolean a) {
        return new MyBoolean(false);
    }

}
