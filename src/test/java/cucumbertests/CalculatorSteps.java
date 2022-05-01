package cucumbertests;

import calculator.*;
import calculator.operation.Divides;
import calculator.operation.Minus;
import calculator.operation.Plus;
import calculator.operation.Times;
import calculator.operation.buildinfunctions.Identity;
import calculator.operation.buildinfunctions.Sin;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import visitor.*;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class CalculatorSteps {

	private ArrayList<Expression> params;
	private Operation op;
	private Function fn;
	private Expression arg;
	private Calculator c;

	@Before
    public void resetMemoryBeforeEachScenario() {
		params = null;
		op = null;
		fn = null;
		arg = null;
	}

	@Given("I initialise a calculator")
	public void givenIInitialiseACalculator() {
		c = new Calculator();
	}

	@Given("a function {string}")
	public void givenAFunction(String s) {
		try{
			fn = switch (s) {
				case "identity" -> new Identity(null);
				case "sin" -> new Sin(null);
				default -> { fail(); throw new RuntimeException("failed"); }
			};
		} catch (IllegalConstruction e) {
			fail();
		}
	}

	@Given("an integer operation {string}")
	public void givenAnIntegerOperation(String s) {
		// Write code here that turns the phrase above into concrete actions
		params = new ArrayList<>(); // create an empty set of parameters to be filled in
		try {
			op = switch (s) {
				case "+" -> new Plus(params);
				case "-" -> new Minus(params);
				case "*" -> new Times(params);
				case "/" -> new Divides(params);
				default -> {
					fail(); throw new RuntimeException("failed.");
				}
			};
		} catch (IllegalConstruction e) {
			fail();
		}
	}

	// The following example shows how to use a DataTable provided as input.
	// (The example looks slightly complex, since DataTables can take as input
	//  tables in two dimensions, i.e. rows and lines. This is why the input
	//  is a list of lists.
	@Given("the following list of integer numbers")
	public void givenTheFollowingListOfNumbers(List<List<String>> numbers) {
		params = new ArrayList<>();
		// Since we only use one line of input, we use get(0) to take the first line of the list,
		// which is a list of strings, that we will manually convert to integers:
		numbers.get(0).forEach(n -> params.add(new Rational(Integer.parseInt(n))));
	    params.forEach(n -> System.out.println("value ="+ n));
		op = null;
	}

	// The string in the Given annotation shows how to use regular expressions...
	// In this example, the notation d+ is used to represent numbers, i.e. nonempty sequences of digits
	@Given("^the sum of two numbers (\\d+) and (\\d+)$")
	// The alternative, and in this case simpler, notation would be:
	// @Given("the sum of two numbers {int} and {int}")
	public void givenTheSum(int n1, int n2) {
		try {
			params = new ArrayList<>();
		    params.add(new Rational(n1));
		    params.add(new Rational(n2));
		    op = new Plus(params);}
		catch(IllegalConstruction e) { fail(); }
	}

	@Then("^its (.*) notation is (.*)$")
	public void thenItsNotationIs(String notation, String s) {
		Printer p = switch (notation) {
			case "PREFIX" -> new PrefixPrinter();
			case "INFIX" -> new InfixPrinter();
			case "POSTFIX" -> new PostfixPrinter();
			default -> {fail(notation + " is not a correct notation! "); yield new InfixPrinter();}
		};
		assertEquals(s, op.toString(p));
	}

	@When("^I provide a (.*) number (\\d+)$")
	public void whenIProvideANumber(String s, int val) {
		params.add(new Rational(val));
	}

	@When("^I provide the argument (\\d+)")
	public void whenIProvideTheArgument(int val) {
		arg = new Real(val);
	}

	@Then("^the (.*) is (\\d+)$")
	public void thenTheOperationIs(String s, int val) {
		try {
			op = switch (s) {
				case "sum" -> new Plus(params);
				case "product" -> new Times(params);
				case "quotient" -> new Divides(params);
				case "difference" -> new Minus(params);
				default -> { fail(); throw new RuntimeException("failed."); }
			};
			assertEquals(new Rational(val), c.eval(op));
		} catch (IllegalConstruction e) {
			fail();
		}
	}

	@Then("the operation evaluates to {int}")
	public void thenTheOperationEvaluatesTo(int val) {
		//During previous @When steps, extra parameters may have been added to the operation
		//so we complete its parameter list here:
		op.addMoreParams(params);
		assertEquals(new Rational(val), c.eval(op));
	}

	@Then("the operation evaluates to {int} over {int}")
	public void thenTheOperationEvaluatesToFraction(int num, int denom) {
		//During previous @When steps, extra parameters may have been added to the operation
		//so we complete its parameter list here:
		op.addMoreParams(params);
		assertEquals(new Rational(num, denom), c.eval(op));
	}

	@Then("the function evaluates to {int}")
	public void thenTheFunctionEvaluatesTo(int result) {
		fn.changeExpression(arg);
		Evaluator e = new Evaluator();
		fn.accept(e);
		assertEquals(new Real(result), e.getResult());
	}

}
