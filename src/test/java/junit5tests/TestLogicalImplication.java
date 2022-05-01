package junit5tests;

import calculator.*;
import calculator.operation.LogicalImplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestLogicalImplication {

    private final boolean value1 = true;
    private final boolean value2 = false;
    private LogicalImplication op;
    private List<Expression> params;

    @BeforeEach
    public void setUp() {
        params = new ArrayList<>(Arrays.asList(new MyBoolean(value1), new MyBoolean(value2)));
        try {
            op = new LogicalImplication(params);
        }
        catch(IllegalConstruction e) { fail(); }
    }


    @Test
    public void testEquals() {
        // Two similar expressions, constructed separately (and using different constructors) should be equal
        ArrayList<Expression> p = new ArrayList<>(Arrays.asList(new MyBoolean(value1), new MyBoolean(value2)));
        try {
            LogicalImplication li = new LogicalImplication(p);
            assertEquals(op, li);
        }
        catch(IllegalConstruction e) { fail(); }
    }

    @Test
    public void testHashCode() {
        // Two similar expressions, constructed separately (and using different constructors) should have the same hashcode
        ArrayList<Expression> p = new ArrayList<>(Arrays.asList(new MyBoolean(value1), new MyBoolean(value2)));
        try {
            LogicalImplication li = new LogicalImplication(p);
            assertEquals(li.hashCode(), op.hashCode());
        }
        catch(IllegalConstruction e) { fail(); }
    }

    @Test
    public void testNullParamList() {
        params = null;
        assertThrows(IllegalConstruction.class, () -> op = new LogicalImplication(params));
    }
}
