package calculator.operation;

import calculator.*;
import calculator.Number;

import java.util.List;

final public class Times extends Operation {


    public /*constructor*/ Times(List<Expression> elist) throws IllegalConstruction {
  	    super(elist);
  	    symbol = "×";
  	    neutral = 1;
    }


    @Override
    public Number op(Number l, Number r){
        return l.multiply(r);
    }

    @Override
    public MyBoolean op(MyBoolean a, MyBoolean b) {
        return null;
    }

    @Override
    public MyBoolean op(MyBoolean a) {
        return null;
    }
}
