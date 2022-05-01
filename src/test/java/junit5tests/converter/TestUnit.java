package junit5tests.converter;

import calculator.Calculator;
import converter.Unit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static converter.Unit.convert;
import static converter.Unit.getUnitCategories;

public class TestUnit {
    @Test
    public void getUnitsByCategory() {
        List<Unit> units = Unit.getUnitsByCategory("Length");
        List<Unit> comparatives = List.of(Unit.Nanometer, Unit.Micronmeter, Unit.Millimeter, Unit.Centimeter,
                Unit.Decimeter, Unit.Meter, Unit.Decameter, Unit.Hectometer, Unit.Kilometer, Unit.Inch, Unit.Feet,
                Unit.Yard, Unit.Mile, Unit.NauticalMile);
        Assertions.assertEquals(comparatives, units);
    }

    @Test
    void getUnitCategoriesTest() {
        List<String> comparatives = List.of("Area", "Data Transfer Rate", "Data Storage", "Energy", "Frequency",
                "Length", "Mass", "Plane Angle", "Pressure", "Speed", "Time", "Volume", "Temperature");
        List<String> categories = getUnitCategories();
        Assertions.assertEquals(comparatives, categories);
    }

    @Test
    void getUnitByNameTest() {
        Unit comparative = Unit.Minute;
        var unit = Unit.getUnitByName("Minute");
        assert unit != null;
        Assertions.assertEquals(comparative, unit);
    }

    @Test
    void testConvertArea() {
        var actual = convert("1", Unit.SquareMeter, Unit.SquareFoot, new Calculator());
        var expected = "10.76385025";
        assert actual.equals(expected);
    }

    @Test
    void testConvertDataTransferRate() {
        var actual = convert("1", Unit.BitPerSecond, Unit.MebibitPerSecond, new Calculator());
        var expected = "9.5367E-7";
        assert actual.equals(expected);
    }

    @Test
    void testConvertDataStorage() {
        var actual = convert("1", Unit.Bit, Unit.Petabit, new Calculator());
        var expected = "1E-15";
        assert actual.equals(expected);
    }

    @Test
    void testConvertEnergy() {
        var actual = convert("1", Unit.Joule, Unit.Kilojoule, new Calculator());
        var expected = "0.001";
        assert actual.equals(expected);
    }

    @Test
    void testConvertFrequency() {
        var actual = convert("1", Unit.Hertz, Unit.Kilohertz, new Calculator());
        var expected = "0.001";
        assert actual.equals(expected);
    }

    @Test
    void testConvertLength() {
        var actual = convert("1", Unit.Meter, Unit.Inch, new Calculator());
        var expected = "39.37008";
        assert actual.equals(expected);
    }

    @Test
    void testConvertMass() {
        var actual = convert("1", Unit.Kilogram, Unit.Gram, new Calculator());
        var expected = "1000";
        assert actual.equals(expected);
    }

    @Test
    void testConvertPlaneAngle() {
        var actual = convert("1", Unit.Radian, Unit.Degree, new Calculator());
        var expected = "57.29575496";
        assert actual.equals(expected);
    }

    @Test
    void testConvertPressure() {
        var actual = convert("1", Unit.Pascal, Unit.Bar, new Calculator());
        var expected = "0.00001";
        assert actual.equals(expected);
    }

    @Test
    void testConvertSpeed() {
        var actual = convert("1", Unit.KilometerPerHour, Unit.MeterPerSecond, new Calculator());
        var expected = "0.2777777778";
        assert actual.equals(expected);
    }

    @Test
    void testConvertTime() {
        var actual = convert("1", Unit.Second, Unit.Minute, new Calculator());
        var expected = "0.01666666667";
        assert actual.equals(expected);
    }

    @Test
    void testConvertTemperature() {
        var actual = convert("1", Unit.Celsius, Unit.Fahrenheit, new Calculator());
        var expected = "33.8";
        assert actual.equals(expected);
    }

    @Test
    void testConvertVolume() {
        var actual = convert("1", Unit.Milliliter, Unit.Liter, new Calculator());
        var expected = "0.001";
        assert actual.equals(expected);
    }
}
