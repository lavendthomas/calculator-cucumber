package junit5tests;

//Import Junit5 libraries for unit testing:
import static org.junit.jupiter.api.Assertions.*;

import calculator.operation.*;
import org.junit.jupiter.api.*;

import calculator.*;
import visitor.Evaluator;

import java.util.Arrays;

public class TestEvaluator {

    @SuppressWarnings("unused")
    private Evaluator visitor;
    private Calculator calc;
    private long value1, value2, value3;
    private Expression op;

    @BeforeEach
    public void setUp() {
        visitor = new Evaluator();
        calc = new Calculator();
        value1 = 8;
        value2 = 6;
        value3 = 2;
    }

    @Test
    public void testEvaluatorMyNumber() {
        assertEquals( new Rational(value1),
                      calc.eval(new Rational(value1)));
    }

    @Test
    public void testEvaluatorDivides() {
        try { op = new Divides(Arrays.asList(new Rational(value1), new Rational(value2)));
          assertEquals( new Rational(value1, value2),
                        calc.eval(op) );
          }
        catch(IllegalConstruction e) {
            fail();
        }
    }

    @Test
    public void testEvaluatorPlus() {
        try { op = new Plus(Arrays.asList(new Rational(value1), new Rational(value2)));
            assertEquals( new Rational(value1 + value2),
                    calc.eval(op) );
        }
        catch(IllegalConstruction e) {
            fail();
        }
    }

    @Test
    public void testEvaluatorMinus() {
        try { op = new Minus(Arrays.asList(new Rational(value1), new Rational(value2)));
            assertEquals( new Rational(value1 - value2),
                    calc.eval(op) );
        }
        catch(IllegalConstruction e) {
            fail();
        }
    }

    @Test
    public void testEvaluatorTimes() {
        try { op = new Times(Arrays.asList(new Rational(value1), new Rational(value2)));
            assertEquals( new Rational(value1 * value2),
                    calc.eval(op) );
        }
        catch(IllegalConstruction e) {
            fail();
        }
    }

    @Test
    public void testEvaluatorPow() {
        try { op = new Pow(Arrays.asList(new Real(value1), new Real(value2)));
            assertEquals( new Real((int) Math.pow(value1, value2)),
                    calc.eval(op) );
        }
        catch(IllegalConstruction e) {
            fail();
        }
    }

    @Test
    public void testEvaluatorPowRational() {
        try { op = new Pow(Arrays.asList(new Rational(value1), new Rational(value2)));
            assertEquals( new Real((int) Math.pow(value1, value2)),
                    calc.eval(op) );
        }
        catch(IllegalConstruction e) {
            fail();
        }
    }

    @Test
    public void testEvaluatorPowRealRat() {
        try { op = new Pow(Arrays.asList(new Real(value1), new Rational(value2, value3)));
            float div = (float) value2 / value3;
            var result = Math.round(Math.pow(value1, div));
            assertEquals( new Real(result+""),
                    calc.eval(op));
        }
        catch(IllegalConstruction e) {
            fail();
        }
    }

    @Test
    public void testEvaluatorPowRatReal() {
        try { op = new Pow(Arrays.asList(new Rational(value2, value3), new Real(value2)));
            float div = (float) value2 / value3;
            var result = Math.round(Math.pow(div, value2));
            assertEquals( new Real(result+""),
                    calc.eval(op));
        }
        catch(IllegalConstruction e) {
            fail();
        }
    }
}
