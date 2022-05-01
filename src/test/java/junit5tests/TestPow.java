package junit5tests;

//Import Junit5 libraries for unit testing:

import calculator.Expression;
import calculator.IllegalConstruction;
import calculator.Rational;
import calculator.operation.Plus;
import calculator.operation.Pow;
import calculator.operation.Times;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import visitor.InfixPrinter;
import visitor.PostfixPrinter;
import visitor.PrefixPrinter;
import visitor.Printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestPow {

	private final int value1 = 8;
	private final int value2 = 6;
	private Pow op;
	private List<Expression> params;

	@BeforeEach
	public void setUp() {
		  params = new ArrayList<>(Arrays.asList(new Rational(value1),new Rational(value2)));
		  try { op = new Pow(params); }
		  catch(IllegalConstruction e) { fail(); }
	}

	@Test
	public void testConstructor1() {
		// It should not be possible to create an expression without null parameter list
		assertThrows(IllegalConstruction.class, () -> op = new Pow(null));
	}

	@SuppressWarnings("AssertBetweenInconvertibleTypes")
	@Test
	public void testConstructor2() {
		// A Pow expression should not be the same as a Times expression
		try {
			assertNotEquals(op, new Times(new ArrayList<>()));
		} catch (IllegalConstruction e) {
			fail();
		}
	}

	@Test
	public void testEquals() {
		// Two similar expressions, constructed separately (and using different constructors) should not be equal
		ArrayList<Expression> p = new ArrayList<>(Arrays.asList(new Rational(value1), new Rational(value2)));
		try {
			Pow e = new Pow(p);
			assertEquals(op, e);
		}
		catch(IllegalConstruction e) { fail(); }
	}

	@SuppressWarnings("ConstantConditions")
	@Test
	public void testEquals2() {
		assertDoesNotThrow(() -> op.equals(null)); // Direct way to to test if the null case is handled.
	}

	@Test
	public void testHashCode() {
		// Two similar expressions, constructed separately (and using different constructors) should have the same hashcode
		ArrayList<Expression> p = new ArrayList<>(Arrays.asList(new Rational(value1), new Rational(value2)));
		try {
			Pow e = new Pow(p);
			assertEquals(e.hashCode(), op.hashCode());
		}
		catch(IllegalConstruction e) { fail(); }
	}

	@Test
	public void testNullParamList() {
		params = null;
		assertThrows(IllegalConstruction.class, () -> op = new Pow(params));
	}

	@Test
	public void testCountDepth() {
		assertEquals(Integer.valueOf(1), op.countDepth());
	}

	@Test
	public void testCountOps() {
		assertEquals(Integer.valueOf(1), op.countOps());
	}

	@Test
	public void testCountNbs() {
		assertEquals(Integer.valueOf(2), op.countNbs());
	}

	@Test
	public void testPowInfix() {
		String prefix = "( " + value1 + " ^ " + value2 + " )";
		var printer = new InfixPrinter();
		printer.visit(op);
		assertEquals(prefix, printer.getBuffer());
	}

	@Test
	public void testPowPrefix() {
		String prefix = "^ (" + value1 + ", " + value2 + ")";
		var printer = new PrefixPrinter();
		printer.visit(op);
		assertEquals(prefix, printer.getBuffer());
	}

	@Test
	public void testPowPostfix() {
		String prefix = "(" + value1 + ", " + value2 + ") ^";
		var printer = new PostfixPrinter();
		printer.visit(op);
		assertEquals(prefix, printer.getBuffer());
	}
}
