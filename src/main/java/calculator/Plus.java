package calculator;

import java.util.List;

final public class Plus extends Operation
{

  public /*constructor*/ Plus(List<Expression> elist) throws IllegalConstruction {
	this(elist, null);
  }
  
  public Plus(List<Expression> elist, Notation n) throws IllegalConstruction {
  	super(elist,n);
  	symbol = "+";
  	neutral = 0;
  }

  public int op(int l, int r) throws IllegalArithmeticOperation {
  	return (l+r);
  }
}
