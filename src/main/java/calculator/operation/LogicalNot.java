package calculator.operation;

import calculator.*;
import calculator.Number;

import java.util.List;

public class LogicalNot extends Operation {

    public LogicalNot(List<Expression> elist) throws IllegalConstruction {
        super(elist);
        symbol = "NOT";
    }

    @Override
    public Number op(Number l, Number r) {
        return null;
    }

    @Override
    public MyBoolean op(MyBoolean a, MyBoolean b) {
        return new MyBoolean(false);
    }

    @Override
    public MyBoolean op(MyBoolean a) {
        return new MyBoolean(!a.getValue());
    }


}
