package junit5tests;

import static org.junit.jupiter.api.Assertions.*;

import calculator.*;
import calculator.operation.Divides;
import calculator.operation.Minus;
import calculator.operation.Plus;
import calculator.operation.Times;
import org.junit.jupiter.api.*;

import java.util.List;

public class TestParser {

    Calculator calculator;
    Parser parser;


    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        parser = new Parser(calculator);
    }

    @Test
    public void testParseInteger() {
        String expr = "5";
        assertEquals(new Rational(5), parser.parse(expr));
    }

    /*
    @Test
    public void testParseDecimal() {
        fail(); // Not yet implemented
    }

    @Test
    public void testParseImaginary() {
        fail(); // Not yet implemented
    }
    */

    @Test
    public void testParseAddition() throws Exception {
        String expr = "1+2";
        assertEquals(
                new Plus(List.of(new Rational(1), new Rational(2))),
                parser.parse(expr)
        );
    }

    @Test
    public void testParseDifference() throws Exception {
        String expr = "1-2";
        assertEquals(
                new Minus(List.of(new Rational(1), new Rational(2))),
                parser.parse(expr)
        );
    }

    @Test
    public void testParseMultiplication() throws Exception {
        String expr = "1×2";
        assertEquals(
                new Times(List.of(new Rational(1), new Rational(2))),
                parser.parse(expr)
        );
    }

    @Test
    public void testParseDivision() throws Exception {
        String expr = "1/2";
        assertEquals(
                new Divides(List.of(new Rational(1), new Rational(2))),
                parser.parse(expr)
        );
    }

    @Test
    public void testParsePriority() throws Exception {
        String expr = "1 + 2 × 3";
        assertEquals(
                new Plus(List.of(new Rational(1),
                        new Times(List.of(new Rational(2), new Rational(3))))),
                parser.parse(expr)
        );
    }

    @Test
    public void testParseParentheses() throws Exception {
        String expr = "(1 + 2) × 3";
        assertEquals(
                new Times(List.of(
                    new Plus(List.of(new Rational(1), new Rational(2))),
                    new Rational(3))),
                parser.parse(expr)
        );
    }
}
