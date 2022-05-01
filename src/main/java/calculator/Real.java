package calculator;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


public class Real extends Number implements Expression{
    private final BigDecimal value;
    protected MathContext mc = new MathContext(10, RoundingMode.HALF_UP);

    /**
     * Constructor
     * @param value the value of the real number
     */
    public /*constructor*/ Real(BigDecimal value) {
        this.value = value;
    }

    /**
     * Constructor
     * @param value the value of the real number
     */
    public Real(String value) {
        this.value = new BigDecimal(value);
    }

    /**
     * Converts a Rational to a Real number
     * @param rat
     */
    public /*constructor*/ Real(Rational rat) {
        BigDecimal  den= new BigDecimal(rat.getDenominator());
        BigDecimal num = new BigDecimal(rat.getNumerator());
        value = num.divide(den, mc);
    }

    /**
     * Constructor
     * @param value the value of the real number
     */
    public /*constructor*/ Real(int value) {
        this.value = new BigDecimal(value);
    }

    /**
     * Constructor
     * @param value the value of the real number
     */
    public Real(long value) {
        this.value = new BigDecimal(value);
    }

    /**
     * Constructor
     * @param value the value of the real number
     */
    public /*constructor*/ Real(Integ value) {
        this.value = new BigDecimal(value.getValue());
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public Real toReal() {
        return this;
    }

    @Override
    public Number negate() {
        return new Real(value.negate());
    }

    @Override
    protected Number add(Integ i) {
        return i.add(this);
    }

    @Override
    protected Number add(Rational rat) {
        Real rati = new Real(rat);

        BigDecimal result = value.add(rati.getValue(), mc);
        return new Real(result);
    }

    @Override
    protected Number add(Real r) {
        BigDecimal result = value.add(r.value, mc);
        return new Real(result);
    }

    @Override
    protected Number add(Complex c) {
        return c.add(this);
    }

    @Override
    protected Number multiply(Integ i) {
        return i.multiply(this);
    }

    @Override
    protected Number multiply(Rational rat) {
        BigDecimal  den= new BigDecimal(rat.getDenominator());
        BigDecimal num = new BigDecimal(rat.getNumerator());
        BigDecimal result = num.divide(den, mc);
        BigDecimal multi = value.multiply(result);
        return new Real(multi);
    }

    @Override
    protected Number multiply(Real r) {
        BigDecimal result = value.multiply(r.value, mc);
        return new Real(result);
    }

    @Override
    protected Number multiply(Complex c) {
        return c.multiply(this);
    }

    @Override
    protected Number divide(Integ i) {
        return this.divide(new Real(i));
    }

    @Override
    protected Number divide(Rational rat) {
        BigDecimal  den= new BigDecimal(rat.getDenominator());
        BigDecimal num = new BigDecimal(rat.getNumerator());
        BigDecimal result = num.divide(den, mc);
        BigDecimal divi = value.divide(result, mc);
        return new Real(divi);
    }

    @Override
    protected Number divide(Real r) {
        BigDecimal result = value.divide(r.value, mc);
        return new Real(result);
    }

    @Override
    protected Number divide(Complex c) {
        Complex c1 = new Complex(this.value);
        return c1.divide(c);
    }

    @Override
    protected Number pow(Rational rat) {
        return pow(rat.toReal());
    }

    @Override
    protected Number pow(Real r) {
        return new Real(BigDecimalMath.pow(value, r.value, mc));
    }

    @Override
    public String toString() {
        return value.toString();
    }


    @Override
    public boolean equals(Object other) {
        if (other instanceof Real r) {
            return value.equals(r.value);
        } else {
            return false;
        }
    }

}