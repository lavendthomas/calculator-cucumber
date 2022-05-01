package junit5tests;
import static org.junit.jupiter.api.Assertions.*;

import calculator.Complex;
import calculator.Integ;

import java.math.BigDecimal;
import java.math.BigInteger;

import calculator.Rational;
import calculator.Real;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestInteg {

    private final int value = 8;
    private final int num1  = 1;
    private final int den1  = 1;
    private final int value2  = 4;
    private final BigDecimal value3  = BigDecimal.valueOf(2);
    private final BigDecimal value4  = BigDecimal.valueOf(4);
    private Integ number;
    private Integ number2;
    private Rational a;
    private Real c;
    private Complex d;


    @BeforeEach
    public void setUp() {
        number = new Integ(value);
        number2 = new Integ(value2);
        a = new Rational(num1, den1);
        c = new Real(value2);
        d = new Complex(value3, value4);

    }

    @Test
    public void testConstructor() {
        assertEquals(new BigInteger(String.valueOf(value)), number.getValue());
    }

    @Test
    public void testAdd() {
        assertEquals((new Integ(12)).getValue(), (new Integ(number.add(c))).getValue());
        assertEquals((new Integ(9)).getValue(), (new Integ(number.add(a))).getValue());
        assertEquals((new Integ(10)).getValue(), (new Integ(number.add(d))).getValue());
    }

    @Test
    public void testMul() {
        assertEquals((new Integ(32)).getValue(), (new Integ(number.multiply(c))).getValue());
        assertEquals((new Integ(8)).getValue(), (new Integ(number.multiply(a))).getValue());
        assertEquals((new Integ(16)).getValue(), (new Integ(number.multiply(d))).getValue());
    }

    @Test
    public void testDiv() {
        assertEquals((new Integ(2)).getValue(), (new Integ(number.divide(c))).getValue());
        assertEquals((new Integ(8)).getValue(), (new Integ(number.divide(a))).getValue());
        assertEquals((new Integ(0)).getValue(), (new Integ(number.divide(d))).getValue());
    }

    @Test
    public void testMod() {
        assertEquals((new Integ(value % value2)).getValue(), (new Integ(number.modulo(c))).getValue());
        assertEquals((new Integ(value % num1)).getValue(), (new Integ(number.modulo(a))).getValue());
        assertEquals((new Integ(value % value2)).getValue(), (new Integ(number.modulo(4))).getValue());
        assertEquals((new Integ(value % value2)).getValue(), (new Integ(number.modulo(number2))).getValue());
    }

    @Test
    public void testPow() {
        assertEquals(new Integ(4096).getValue(), new Integ(number.pow(c)).getValue());
    }

    @Test
    public void testNeg() {
        assertEquals((new Integ(-value)).getValue(), (new Integ(number.negate()).getValue()));
    }

    @Test
    public void testGcd(){

        assertEquals(new Integ(4).getValue(), new Integ(number.gcd(c)).getValue());
        assertEquals(new Integ(1).getValue(), new Integ(number.gcd(a)).getValue());
        assertEquals(new Integ(4).getValue(), new Integ(number.gcd(4)).getValue());
        assertEquals(new Integ(4).getValue(), new Integ(number.gcd(number2)).getValue());
    }

    @Test
    public void testConversion(){
        assertEquals("1000", number.conversion(10,2));
    }


}
