package converter;

import calculator.Integ;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public enum IntegerEnum {
    Base2("Base2", 2),
    Base3( "Base3", 3),
    Base4( "Base4", 4),
    Base5( "Base5", 5),
    Base6("Base6", 6),
    Base7( "Base7", 7),
    Base8("Base8", 8),
    Base9("Base9", 9),
    Base10( "Base10", 10)
    ;
    private final String name;
    private final int value;

    IntegerEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public static List<IntegerEnum> getIntegerUnits() {
        return Arrays.stream(IntegerEnum.values()).toList();
    }

    public static IntegerEnum getIntegerUnit(String name) {
        return Arrays.stream(IntegerEnum.values()).filter(unit -> unit.getName().equals(name)).findFirst().get();
    }

    public static String convertInt(String input, IntegerEnum fromBase, IntegerEnum toBase) {
        Integ in = new Integ(new BigInteger(input));
        return in.conversion(fromBase.getValue(), toBase.getValue());
    }
}
