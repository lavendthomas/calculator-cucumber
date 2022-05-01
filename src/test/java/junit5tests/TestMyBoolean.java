package junit5tests;

//Import Junit5 libraries for unit testing:

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import calculator.MyBoolean;


public class TestMyBoolean {

    private final boolean value = true;
    private MyBoolean myBoolean;

    @BeforeEach
    public void setUp() {
        myBoolean = new MyBoolean(value);
    }

    @Test
    public void testEquals(){
        // Two distinct MyBoolean, constructed separately (using a different constructor) but containing the same value should be equal
        assertEquals(new MyBoolean(value), myBoolean);
        // Two MyNumbers containing a distinct value should not be equal:
        boolean otherValue = false;
        assertNotEquals(new MyBoolean(otherValue),myBoolean);
        assertEquals(myBoolean, myBoolean); // Identity check (for coverage, as this should always be true)
    }

    @Test
    public void testCountDepth() {
        //test whether a number has zero depth (i.e. no nested expressions)
        assertEquals(Integer.valueOf(0), myBoolean.countDepth());
    }

    @Test
    public void testCountOps() {
        //test whether a number contains zero operations
        assertEquals(Integer.valueOf(0), myBoolean.countOps());
    }

    @Test
    public void testCountNbs() {
        //test whether a number contains 1 number
        assertEquals(Integer.valueOf(1), myBoolean.countNbs());
    }

    @Test
    public void testToString() {
        assertEquals(value?"1":"0", myBoolean.toString());
    }
}
