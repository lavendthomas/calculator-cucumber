package calculator;

import java.util.List;

final public class Minus extends Operation
{

  public /*constructor*/ Minus(List<Expression> elist) throws IllegalConstruction {
  	this(elist, null);
  }

  public Minus(List<Expression> elist, Notation n) throws IllegalConstruction {
  	super(elist,n);
  	symbol = "-";
  	neutral = 0;
  }
  
  public int op(int l, int r) throws IllegalArithmeticOperation {
  	return (l-r);
  }
}
