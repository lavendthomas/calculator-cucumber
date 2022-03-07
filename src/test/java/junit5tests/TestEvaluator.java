package junit5tests;

//Import Junit5 libraries for unit testing:
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import calculator.*;
import visitor.Evaluator;

import java.util.Arrays;

public class TestEvaluator {

    @SuppressWarnings("unused")
    private Evaluator visitor;
    private Calculator calc;
    private int value1, value2;
    private Expression op;

    @BeforeEach
    public void setUp() {
        visitor = new Evaluator();
        calc = new Calculator();
        value1 = 8;
        value2 = 6;
    }

    @Test
    public void testEvaluatorMyNumber() {
        assertEquals( value1,
                      calc.eval(new MyNumber(value1)).get().intValue());
    }

    @Test
    public void testEvaluatorDivides() {
        try { op = new Divides(Arrays.asList(new MyNumber(value1), new MyNumber(value2)));
          assertEquals( value1 / value2,
                        calc.eval(op).get().intValue() );
          }
        catch(IllegalConstruction e) {
            fail();
        }
    }

    @Test
    public void testEvaluatorPlus() {
        try { op = new Plus(Arrays.asList(new MyNumber(value1), new MyNumber(value2)));
            assertEquals( value1 + value2,
                    calc.eval(op).get().intValue() );
        }
        catch(IllegalConstruction e) {
            fail();
        }
    }

    @Test
    public void testEvaluatorMinus() {
        try { op = new Minus(Arrays.asList(new MyNumber(value1), new MyNumber(value2)));
            assertEquals( value1 - value2,
                    calc.eval(op).get().intValue() );
        }
        catch(IllegalConstruction e) {
            fail();
        }
    }

    @Test
    public void testEvaluatorTimes() {
        try { op = new Times(Arrays.asList(new MyNumber(value1), new MyNumber(value2)));
            assertEquals( value1 * value2,
                    calc.eval(op).get().intValue() );
        }
        catch(IllegalConstruction e) {
            fail();
        }
    }

}
