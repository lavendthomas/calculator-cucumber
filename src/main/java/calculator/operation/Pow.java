package calculator.operation;

import calculator.Number;
import calculator.*;

import java.util.List;

final public class Pow extends Operation
{

  public /*constructor*/ Pow(List<Expression> elist) throws IllegalConstruction {
	super(elist);
	symbol = "^";
	neutral = 1;
  }

    @Override
    public Number op(Number l, Number r) {
        return l.pow(r);
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
