package junit5tests;

//Import Junit5 libraries for unit testing:
import static org.junit.jupiter.api.Assertions.*;

import calculator.*;
import calculator.Number;
import calculator.operation.Times;
import org.junit.jupiter.api.*;

import java.math.BigInteger;
import java.util.ArrayList;

public class TestRational {

	private final int value = 8;
	private final int num1  = 1;
	private final int den1  = 4;
	private final int num2  = 2;
	private final int den2  = 5;
	private Number number;
	private Rational a;
	private Rational b;


	@BeforeEach
	public void setUp() {
		number = new Rational(value);
		a = new Rational(num1, den1);
		b = new Rational(num2, den2);
	}

	@Test
	public void testEquals() {
		// Two distinct Rationals, constructed separately (using a different constructor) but containing the same value should be equal
		assertEquals(new Rational(value), number);
		// Two Rationals containing a distinct value should not be equal:
		int otherValue = 7;
		assertNotEquals(new Rational(otherValue),number);
		assertEquals(number, number); // Identity check (for coverage, as this should always be true)
		assertNotEquals(number, value);
		try {
			assertNotEquals(new Times(new ArrayList<>()), number);
		}
		catch (IllegalConstruction e) {fail();}
		// Two Rationals created with different simplification factors should be equal:
		Rational a_alt = new Rational(2, 8);
		assertEquals(a, a_alt);
	}

	@Test
	public void testCountDepth() {
		//test whether a number has zero depth (i.e. no nested expressions)
		assertEquals(Integer.valueOf(0), number.countDepth());
	}

	@Test
	public void testCountOps() {
		//test whether a number contains zero operations
		assertEquals(Integer.valueOf(0), number.countOps());
	}

	@Test
	public void testCountNbs() {
		//test whether a number contains 1 number
		assertEquals(Integer.valueOf(1), number.countNbs());
	}

	@Test
	public void testToString() {
		assertEquals(Integer.toString(value), number.toString());
	}

	@Test
	public void testAddition() {
		assertEquals(new Rational(13, 20), a.add(b));
	}

	@Test
	public void testAdditionSymmetry() {
		assertEquals(b.add(a), a.add(b));
	}

	@Test
	public void testDifference() {
		assertEquals(new Rational(-3, 20), a.subtract(b));
	}

	@Test
	public void testMultiplication() {
		assertEquals(new Rational(2, 20), a.multiply(b));
	}

	@Test
	public void testMultiplicationSymmetry() {
		assertEquals(b.multiply(a), a.multiply(b));
	}

	@Test
	public void testDivision() {
		assertEquals(new Rational(5, 8), a.divide(b));
	}

	@Test
	public void testNegation() {
		assertEquals(new Rational(-1, 4), a.negate());
	}

	@Test
	public void testComparison() {
		assertTrue(a.compareTo(b) > 0);
		assertTrue(b.compareTo(a) < 0);
		assertTrue(b.compareTo((Rational) a.negate()) > 0);
		assertTrue(new Rational(0).compareTo(new Rational(0)) == 0);
		assertEquals(0, a.compareTo(new Rational(num1, den1)));
	}

	@Test
	public void testEmptyConstructor() {
		assertEquals(new Rational(), new Rational(0, 1));
	}

	@Test
	public void testConstructorNegate() {
		assertEquals(new Rational(-5, 1).toReal(), new Real(-5));
	}

	@Test
	public void testToReal() {
		assertEquals(a.toReal(), new Real("0.25"));
	}



}
