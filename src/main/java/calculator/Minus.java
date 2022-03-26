package calculator;

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


}
