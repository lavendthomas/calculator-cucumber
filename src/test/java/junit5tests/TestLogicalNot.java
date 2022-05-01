package junit5tests;

import calculator.*;
import calculator.operation.LogicalNot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestLogicalNot {

    private final boolean value1 = true;
    private LogicalNot op;
    private List<Expression> params;

    @BeforeEach
    public void setUp() {
        params = new ArrayList<>(List.of(new MyBoolean(value1)));
        try {
            op = new LogicalNot(params);
        }
        catch(IllegalConstruction e) { fail(); }
    }


    @Test
    public void testEquals() {
        // Two similar expressions, constructed separately (and using different constructors) should be equal
        ArrayList<Expression> p = new ArrayList<>(List.of(new MyBoolean(value1)));
        try {
            LogicalNot ln = new LogicalNot(p);
            assertEquals(op, ln);
        }
        catch(IllegalConstruction e) { fail(); }
    }

    @Test
    public void testHashCode() {
        // Two similar expressions, constructed separately (and using different constructors) should have the same hashcode
        ArrayList<Expression> p = new ArrayList<>(List.of(new MyBoolean(value1)));
        try {
            LogicalNot ln = new LogicalNot(p);
            assertEquals(ln.hashCode(), op.hashCode());
        }
        catch(IllegalConstruction e) { fail(); }
    }

    @Test
    public void testNullParamList() {
        params = null;
        assertThrows(IllegalConstruction.class, () -> op = new LogicalNot(params));
    }
}


