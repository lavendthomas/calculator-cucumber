package calculator;

import visitor.InfixPrinter;
import visitor.Printer;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public abstract class Operation implements Expression
{  
  public List<Expression> args;
  protected String symbol;
  protected int neutral; // the neutral element of the operation (e.g. 1 for *, 0 for +)


  public List<Expression> getArgs() {
  	return args;
  }

  // It is not allowed to create operation that have a null list of arguments.
  // Note that it is allowed to have an EMPTY list of arguments.
  public /*constructor*/ Operation(List<Expression> elist)
		  throws IllegalConstruction
  {
	  if (elist == null) {
		  throw new IllegalConstruction(); }
	  else {
		  args = new ArrayList<>(elist);
	  }
  }
  
  abstract public Number op(Number l, Number r);
    // the operation itself is specified in the subclasses

	abstract public  MyBoolean op(MyBoolean a, MyBoolean b);

	abstract public MyBoolean op(MyBoolean a);


  // add more arguments to the existing list of arguments args
  public void addMoreParams(List<Expression> params) {
  	args.addAll(params);
  }

  public void accept(Visitor v) {
  	// ask each of the argument expressions of the current operation to accept the visitor
  	for(Expression a:args) { a.accept(v); }
  	// and then visit the current operation itself
    v.visit(this);
  }

	final public Integer countDepth() {
	    // use of Java 8 functional programming capabilities
	return 1 + args.stream()
			   .mapToInt(Expression::countDepth)
			   .max()
			   .getAsInt();  
  }

  final public Integer countOps() {
	    // use of Java 8 functional programming capabilities
	return 1 + args.stream()
			   .mapToInt(Expression::countOps)
			   .reduce(Integer::sum)
			   .getAsInt();
  }

  final public Integer countNbs() {
	    // use of Java 8 functional programming capabilities
	return args.stream()
			   .mapToInt(Expression::countNbs)
			   .reduce(Integer::sum)
			   .getAsInt();  
  }

	public String getSymbol() {
		return symbol;
	}

  @Override
  final public String toString() {
	Printer p = new InfixPrinter();
  	return toString(p);
  }

  final public String toString(Printer p) {
	  p.visit(this);
	  return p.getBuffer();
  }

	//Two Operation expressions are equal if their list of arguments is equal and they are the same operation
	@Override
	public boolean equals(Object o) {
		if (o == null) return false; // No object should be equal to null

		if (this == o) return true; // If it's the same object, they're obviously equal

		if (getClass() != o.getClass()) return false; // getClass() instead of instanceof() because an addition is not the same as a multiplication

		Operation other = (Operation) o;
		return this.args.equals(other.getArgs());
	  }

    // The method hashCode also needs to be overridden it the equals method is overridden; otherwise there may be problems when you use your object in hashed collections such as HashMap, HashSet, LinkedHashSet
	@Override
	public int hashCode()
	{
		int result = 5, prime = 31;
		result = prime * result + neutral;
		result = prime * result + symbol.hashCode();
		result = prime * result + args.hashCode();
		return result;
	}

}
