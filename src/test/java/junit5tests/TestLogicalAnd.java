package junit5tests;

import static org.junit.jupiter.api.Assertions.*;

import calculator.operation.LogicalAnd;
import org.junit.jupiter.api.*;

import calculator.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestLogicalAnd {

    private final boolean value1 = true;
    private final boolean value2 = false;
    private LogicalAnd op;
    private List<Expression> params;

    @BeforeEach
    public void setUp() {
        params = new ArrayList<>(Arrays.asList(new MyBoolean(value1), new MyBoolean(value2)));
        try {
            op = new LogicalAnd(params);
        }
        catch(IllegalConstruction e) { fail(); }
    }


    @Test
    public void testEquals() {
        // Two similar expressions, constructed separately (and using different constructors) should be equal
        ArrayList<Expression> p = new ArrayList<>(Arrays.asList(new MyBoolean(value1), new MyBoolean(value2)));
        try {
            LogicalAnd la = new LogicalAnd(p);
            assertEquals(op, la);
        }
        catch(IllegalConstruction e) { fail(); }
    }

    @Test
    public void testHashCode() {
        // Two similar expressions, constructed separately (and using different constructors) should have the same hashcode
        ArrayList<Expression> p = new ArrayList<>(Arrays.asList(new MyBoolean(value1), new MyBoolean(value2)));
        try {
            LogicalAnd e = new LogicalAnd(p);
            assertEquals(e.hashCode(), op.hashCode());
        }
        catch(IllegalConstruction e) { fail(); }
    }

    @Test
    public void testNullParamList() {
        params = null;
        assertThrows(IllegalConstruction.class, () -> op = new LogicalAnd(params));
    }
}
