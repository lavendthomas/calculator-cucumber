package calculator;

import java.util.List;

final public class Times extends Operation
{

  public /*constructor*/ Times(List<Expression> elist) throws IllegalConstruction {
  	this(elist, null);
  }

  public Times(List<Expression> elist, Notation n) throws IllegalConstruction {
  	super(elist,n);
  	symbol = "*";
  	neutral = 1;
  }
  
  public int op(int l, int r) throws IllegalArithmeticOperation
    { return (l*r); }
}
