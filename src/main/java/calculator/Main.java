package calculator;

import calculator.operation.Divides;
import calculator.operation.Minus;
import calculator.operation.Plus;
import calculator.operation.Times;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***************************************
 * A very simple Calculator in Java    *
 * Tom Mens, February 2021             *
 * University of Mons - UMONS          *
 * Département d'Informatique          *
 * Faculté des Sciences                *
 ***************************************/

public class Main {

  public static void main(String[] args) {

  	Expression e;
  	Calculator c = new Calculator();

	  var l = new Parser(c).parse("toto:=sin(x)+1");
//	  System.out.println(c.eval(l));
	  var lr = new Parser(c).parse("toto(1)");
	  System.out.println(c.eval(lr));


	  /*

	try{
		// Here is an example of how to use the calculator:

		e = new Rational(8);
		c.print(e);
		c.eval(e);

	    List<Expression> params = new ArrayList<>();
	    Collections.addAll(params, new Rational(3), new Rational(4), new Rational(5));
	    e = new Plus(params);
		c.eval(e);
	
		List<Expression> params2 = new ArrayList<>();
		Collections.addAll(params2, new Rational(5), new Rational(3));
		e = new Minus(params2);
		c.print(e);
		c.eval(e);

		List<Expression> params3 = new ArrayList<>();
		Collections.addAll(params3, new Plus(params), new Minus(params2));
		e = new Times(params3);
		c.eval(e);

		List<Expression> params4 = new ArrayList<>();
		Collections.addAll(params4, new Plus(params), new Minus(params2), new Rational(5));
		e = new Divides(params4);
		c.print(e);
		c.eval(e);

		List<Expression> my_params1 = new ArrayList<>();
		List<Expression> my_params = new ArrayList<>();
		Collections.addAll(my_params, new MyBoolean(false), new MyBoolean(true));
		Collections.addAll(my_params1, new MyBoolean(false), new MyBoolean(false));
		List<Expression> params5 = new ArrayList<>();
		Collections.addAll(params5, new LogicalAnd(my_params1), new LogicalOr(my_params), new MyBoolean(true));
		e = new LogicalOr(params5);
		c.print(e);
		c.evalBool(e);

	}

	catch(IllegalConstruction exception) {
		System.out.println("cannot create operations without parameters");
		}

	   */
 	}

}
