package calculator;

import java.math.BigInteger;

public class Integ extends Number{

    private BigInteger value;

    /**
     * Constructor
     * @param value a BigInteger value
     */
    public Integ(BigInteger value) {
        this.value = value;
    }

    /**
     * Constructor
     * @param value a int value
     */
    public Integ(int value) {
        this.value = new BigInteger(String.valueOf(value));
    }

    /**
     * Constructor
     * @param num a object Number
     */
    public Integ(Number num) {
        this.value = num.toReal().getValue().toBigInteger();
    }

    @Override
    public Real toReal() {
        return new Real(this);
    }

    @Override
    public Number negate() {
        return new Integ(value.negate());
    }

    @Override
    protected Number add(Integ i) {
        return new Integ(value.add(i.getValue()));
    }

    @Override
    protected Number add(Rational rat) {
        return rat.add(new Rational(this));
    }

    @Override
    protected Number add(Real r) {
        return r.add(this.toReal());
    }

    @Override
    protected Number add(Complex c) {
        return c.add(new Complex(this));
    }

    @Override
    protected Number multiply(Integ i) {
        return new Integ(value.multiply(i.getValue()));
    }

    @Override
    protected Number multiply(Rational rat) {
        return rat.multiply(new Rational(this));
    }

    @Override
    protected Number multiply(Real r) {
        return r.multiply(this.toReal());
    }

    @Override
    protected Number multiply(Complex c) {
        return c.multiply(new Complex(this));
    }

    @Override
    protected Number divide(Integ i) {
        return new Integ(value.divide(i.getValue()));
    }

    @Override
    protected Number divide(Rational rat) {
        Rational r = new Rational(this);
        return r.divide(rat);
    }

    @Override
    protected Number divide(Real r) {
        Real r1 = new Real(this);
        return r1.divide(r);
    }

    @Override
    protected Number divide(Complex c) {
        Complex c1 = new Complex(this);
        return c1.divide(c);
    }

    @Override
    protected Number pow(Rational rat) {
        return new Integ(value.pow(rat.toReal().getValue().toBigInteger().intValue()));
    }

    @Override
    protected Number pow(Real r) {
        return new Integ(value.pow(r.getValue().toBigInteger().intValue()));
    }

    /**
     * @return the value
     */
    public BigInteger getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    /**
     * @param init the value of the initial base
     * @param end the value of the final base
     * @return fin the string with the value of the base's -sion
     */
    public String conversion(int init, int end) {
        final String depart = this.toString();
        final int dec = Integer.parseInt(depart, init);
        return Integer.toString(dec, end);
    }

    /**
     * @param modulo a int the value of the modulo
     * @return the value of the modulo
     */
    public Integ modulo(int modulo) {
        return new Integ(value.mod(BigInteger.valueOf(modulo)));
    }

    /**
     * @param integ a Integ the value of the modulo
     * @return the value of the modulo
     */
    public Integ modulo(Integ integ) {
        return new Integ(value.mod(integ.getValue()));
    }

    /**
     * @param rat a Rationnal the value of the modulo
     * @return the value of the modulo
     */
    public Integ modulo(Rational rat) {
        return new Integ(value.mod(rat.toReal().getValue().toBigInteger()));
    }

    /**
     * @param r a Real the value of the modulo
     * @return the value of the modulo
     */
    public Integ modulo(Real r) {
        return new Integ(value.mod(r.getValue().toBigInteger()));
    }

    /**
     *
     * @param i a int
     * @return the value of the gcd
     */
    public Integ gcd(int i) {
        return new Integ(value.gcd(BigInteger.valueOf(i)));
    }

    /**
     *
     * @param integ a Integ
     * @return the value of the gcd
     */
    public Integ gcd(Integ integ) {
        return new Integ(value.gcd(integ.getValue()));
    }

    /**
     *
     * @param rat a Rational
     * @return the value of the gcd
     */
    public Integ gcd(Rational rat) {
        return new Integ(value.gcd(rat.toReal().getValue().toBigInteger()));
    }

    /**
     *
     * @param r a Real
     * @return the value of the gcd
     */
    public Integ gcd(Real r) {
        return new Integ(value.gcd(r.getValue().toBigInteger()));
    }

}
