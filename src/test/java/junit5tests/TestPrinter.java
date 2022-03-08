package junit5tests;

import calculator.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import visitor.InfixPrinter;
import visitor.PostfixPrinter;
import visitor.PrefixPrinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestPrinter {

    private final int value1 = 8;
    private final int value2 = 6;
    private final int value3 = 4;
    private Plus op;
    private List<Expression> params;

    @BeforeEach
    public void setUp() {
        params = new ArrayList<>();
        List<Expression> params1 = new ArrayList<>(Arrays.asList(new MyNumber(value1),new MyNumber(value2)));
        try {
            Collections.addAll(params, new Minus(params1), new MyNumber(value3));
        } catch (IllegalConstruction e) {
            fail();
        }
        try {
            op = new Plus(params);
        }
        catch(IllegalConstruction e) { fail(); }
    }


    @Test
    public void testRecursivePrefixPrinter() {
        String prefix = "+ (- (" + value1 + ", " + value2 + "), " + value3 + ")";
        var printer = new PrefixPrinter();
        printer.visit(op);
        assertEquals(prefix, printer.getBuffer());
    }

    @Test
    public void testRecursiveInfixPrinter() {
        String prefix = "( ( " + value1 + " - " + value2 + " ) + " + value3 + " )";
        var printer = new InfixPrinter();
        printer.visit(op);
        assertEquals(prefix, printer.getBuffer());
    }

    @Test
    public void testRecursivePostfixPrinter() {
        String prefix = "((" + value1 + ", " + value2 + ") -, " + value3 + ") +";
        var printer = new PostfixPrinter();
        printer.visit(op);
        assertEquals(prefix, printer.getBuffer());
    }

}
