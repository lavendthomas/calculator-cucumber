package calculator.operation;

import calculator.*;
import calculator.Number;

import java.util.List;

final public class Minus extends Operation
{

  public /*constructor*/ Minus(List<Expression> elist) throws IllegalConstruction {
  	super(elist);
  	symbol = "-";
  	neutral = 0;
  }


    @Override
    public Number op(Number l, Number r) {
        return l.subtract(r);
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
