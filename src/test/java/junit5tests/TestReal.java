package junit5tests;

import calculator.*;
import calculator.Number;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestReal {

    private final int value = 8;
    private final int num1  = 1;
    private final int den1  = 1;
    private final int value2  = 4;
    private Real number;
    private Rational a;
    private Real c;
    private Real d;


    @BeforeEach
    public void setUp() {
        number = new Real(value);
        a = new Rational(num1, den1);
        c = new Real(value);
        d = new Real(value2);


    }

    @Test
    public void testEquals() {

        int otherValue = 7;
        int value = 8;
        Real value1 = new Real(value);
        Real value2 = new Real(otherValue);
        // Two Reals containing a equals value should be equal:
        assertEquals(value1.getValue(),number.getValue());
        // Two Reals containing a distinct value should not be equal:
        assertNotEquals(value2.getValue(),number.getValue());

        assertEquals(number.getValue(), number.getValue()); // Identity check (for coverage, as this should always be true)
        assertNotEquals(number.getValue(), value);
    }



    @Test
    public void testAddition() {
        Number adi = c.add(d);
        Real add = (Real) adi;
        assertEquals(new Real(12).getValue(), add.getValue());

        Number adi1 = c.add(a);
        Real add2 = (Real) adi1;
        assertEquals(new Real(9).getValue(), add2.getValue());

    }

    @Test
    public void testMultiplication() {
        Number mul = c.multiply(d);
        Real mul1 = (Real) mul;
        assertEquals(new Real(32).getValue(), mul1.getValue());

        Number mul2 = c.multiply(a);
        Real mul3 = (Real) mul2;
        assertEquals(new Real(8).getValue(), mul3.getValue());

    }

    @Test
    public void testDivision() {
        Number div = c.divide(d);
        Real div1 = (Real) div;
        assertEquals(new Real(2).getValue(), div1.getValue());

        Number div2 = c.divide(a);
        Real div3 = (Real) div2;
        assertEquals(new Real(8).getValue(), div3.getValue());

    }

    @Test
    public void testNegation() {
        Number neg = c.negate();
        Real neg1 = (Real) neg;
        assertEquals(new Real(-8).getValue(), neg1.getValue());

    }



}
