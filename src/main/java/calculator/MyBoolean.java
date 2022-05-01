package calculator;

import visitor.Visitor;

public class MyBoolean implements Expression{

    private final boolean value;

    public boolean getValue() { return value; }

    public /*constructor*/ MyBoolean(boolean v) {
        value=v;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public Integer countDepth() {
        return 0;
    }

    @Override
    public Integer countOps() {
        return 0;
    }

    @Override
    public Integer countNbs() {
        return 1;
    }

    /*
     * string representation of a MyBoolean
     * 1 => true and 0 => false
     */
    @Override
    public String toString() {
        return value?"1":"0";
    }


    //Two MyBoolean expressions are equal if the values they contain are equal
    @Override
    public boolean equals(Object o) {
        // No object should be equal to null (not including this check can result in an exception if a MyNumber is tested against null)
        if (o == null) return false;

        // If the object is compared to itself then return true
        if (o == this) {
            return true;
        }

        // If the object is of another type then return false
        if (!(o instanceof MyBoolean)) {
            return false;
        }
        return this.value == ((MyBoolean)o).value;
        // I used == above since the contained value is a primitive value
        // If it had been a Java object, .equals() would be needed
    }

    // The method hashCode() needs to be overridden if the equals method is overridden; otherwise there may be problems when you use your object in hashed collections such as HashMap, HashSet, LinkedHashSet
    @Override
    public int hashCode() {
        return toString().hashCode();
    }

}

