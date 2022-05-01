package junit5tests;

import static org.junit.jupiter.api.Assertions.*;

import calculator.Complex;

import java.math.BigDecimal;

import calculator.Rational;
import calculator.Real;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestComplex {

    private final BigDecimal real = BigDecimal.valueOf(1);
    private final BigDecimal imaginary = BigDecimal.valueOf(2);
    private Complex c1;
    private Complex c2;
    private Complex cA;
    private Complex cB;
    private Complex cC;


    @BeforeEach
    public void setUp() {
        c1 = new Complex(real, imaginary);
        c2 = new Complex(real, imaginary);
        cA = new Complex(BigDecimal.valueOf(2), BigDecimal.valueOf(3));
        cB = new Complex(BigDecimal.valueOf(0), BigDecimal.valueOf(4));
        cC = new Complex(BigDecimal.valueOf(4), BigDecimal.valueOf(3));

    }

    @Test
    public void testEquals() {
        assertEquals(BigDecimal.valueOf(1), c1.getReal());
        assertEquals(BigDecimal.valueOf(2), c1.getImaginary());
    }

    @Test
    public void testAdd(){

        Complex c3 = (Complex) c1.add(c2);


        assertEquals(BigDecimal.valueOf(2), c3.getReal());
        assertEquals(BigDecimal.valueOf(4), c3.getImaginary());
    }


    @Test
    public void testMultiply(){

        Complex c3 = (Complex) c1.multiply(c2);
        assertEquals(BigDecimal.valueOf(-3), c3.getReal());
        assertEquals(BigDecimal.valueOf(4), c3.getImaginary());
    }

    @Test
    public void testDivide(){

        Complex c3 = (Complex) c1.divide(c2);
        assertEquals(BigDecimal.valueOf(1), c3.getReal());
        assertEquals(BigDecimal.valueOf(0), c3.getImaginary());

        Complex c4 = new Complex(BigDecimal.valueOf(20), BigDecimal.valueOf(-4));
        Complex c5 = new Complex(BigDecimal.valueOf(3), BigDecimal.valueOf(2));

        Complex c6 = (Complex) c4.divide(c5);
        assertEquals(BigDecimal.valueOf(4), c6.getReal());
        assertEquals(BigDecimal.valueOf(-4), c6.getImaginary());
    }

    @Test
    public void testToString(){
        Complex c1 = new Complex(real, imaginary);
        assertEquals("1 + 2i", c1.toString());
    }

    @Test
    public void testConjugate(){

        Complex c3 = c1.conjugate();
        assertEquals(BigDecimal.valueOf(1), c3.getReal());
        assertEquals(BigDecimal.valueOf(-2), c3.getImaginary());
    }

    @Test
    public void testPow(){

        Complex c3 = (Complex) cA.pow(new Rational(0));
        Complex c4 = (Complex) cA.pow(new Rational(1));
        Complex c5 = (Complex) cB.pow(new Rational(4));
        Complex c6 = (Complex) cC.pow(new Rational(3));

        assertEquals(BigDecimal.valueOf(1), c3.getReal());
        assertEquals(BigDecimal.valueOf(0), c3.getImaginary());

        assertEquals(BigDecimal.valueOf(2), c4.getReal());
        assertEquals(BigDecimal.valueOf(3), c4.getImaginary());

        assertEquals(BigDecimal.valueOf(-256), c5.getReal());
        assertEquals(BigDecimal.valueOf(0), c5.getImaginary());

        assertEquals(BigDecimal.valueOf(-44), c6.getReal());
        assertEquals(BigDecimal.valueOf(117), c6.getImaginary());

        Complex c7 = (Complex) cA.pow(new Real(0));
        Complex c8 = (Complex) cA.pow(new Real(1));
        Complex c9 = (Complex) cB.pow(new Real(4));
        Complex c10 = (Complex) cC.pow(new Real(3));

        assertEquals(BigDecimal.valueOf(1), c7.getReal());
        assertEquals(BigDecimal.valueOf(0), c7.getImaginary());

        assertEquals(BigDecimal.valueOf(2), c8.getReal());
        assertEquals(BigDecimal.valueOf(3), c8.getImaginary());

        assertEquals(BigDecimal.valueOf(-256), c9.getReal());
        assertEquals(BigDecimal.valueOf(0), c9.getImaginary());

        assertEquals(BigDecimal.valueOf(-44), c10.getReal());
        assertEquals(BigDecimal.valueOf(117), c10.getImaginary());


    }


}
