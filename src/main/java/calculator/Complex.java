package calculator;

import java.math.BigDecimal;

public class Complex extends Number implements Expression {

    private BigDecimal real;
    private BigDecimal imaginary;

    /**
     * Constructor for Complex
     *
     * @param real a part real of the complex number
     * @param imaginary a part imaginary of the complex number
     */
    public Complex(BigDecimal real, BigDecimal imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * Constructor for Complex
     *
     * @param real a part real of the complex number
     */
    public Complex(BigDecimal real) {
        this.real = real;
        this.imaginary = BigDecimal.ZERO;
    }

    public Complex(Integ inte){
        this.real = inte.toReal().getValue();
        this.imaginary = BigDecimal.ZERO;
    }

    /**
     * @return the real part of the complex number
     */
    public BigDecimal getReal() {
        return real;
    }

    /**
     * @return the imaginary part of the complex number
     */
    public BigDecimal getImaginary() {
        return imaginary;
    }

    @Override
    public Real toReal() {
        return new Real(real);
    }

    /**
     * @return the conjugate of the complex number
     */
    public Complex conjugate() {
        return new Complex(real, imaginary.negate());
    }

    @Override
    public Number negate() {
        return new Complex(real.negate(), imaginary.negate());
    }

    @Override
    protected Number add(Integ i) {
        return new Complex(real.add(i.toReal().getValue()), imaginary);
    }

    @Override
    protected Number add(Rational rat) {
        return new Complex(real.add(rat.toReal().getValue()), imaginary);
    }

    @Override
    protected Number add(Real r) {
        return new Complex(real.add(r.getValue()), imaginary);
    }

    @Override
    protected Number add(Complex c) {
        Complex addi = new Complex(real.add(c.getReal()), imaginary.add(c.getImaginary()));
        return addi;
    }

    @Override
    protected Number multiply(Integ i) {
        return i.multiply(this);
    }

    @Override
    protected Number multiply(Rational rat) {
        return new Complex(real.multiply(rat.toReal().getValue()), imaginary.multiply(rat.toReal().getValue()));
    }

    @Override
    protected Number multiply(Real r) {
        return new Complex(real.multiply(r.getValue()), imaginary.multiply(r.getValue()));
    }

    @Override
    protected Number multiply(Complex c) {
        BigDecimal r1 = real;
        BigDecimal r2 = c.getReal();
        BigDecimal i1 = imaginary;
        BigDecimal i2 = c.getImaginary();

        BigDecimal pr = (r1.multiply(r2)).add((i1.multiply(i2)).negate());
        BigDecimal pi = (r1.multiply(i2)).add((i1.multiply(r2)));

        return new Complex(pr, pi);
    }

    @Override
    protected Number divide(Integ i) {
        return this.divide(i.toReal());
    }

    @Override
    protected Number divide(Rational rat) {
        return new Complex(real.divide(rat.toReal().getValue()), imaginary.divide(rat.toReal().getValue()));
    }

    @Override
    protected Number divide(Real r) {
        return new Complex(real.divide(r.getValue()), imaginary.divide(r.getValue()));
    }

    @Override
    protected Number divide(Complex c) {

        Complex num = (Complex) this.multiply(c.conjugate());
        Complex den = (Complex) c.multiply(c.conjugate());

        return new Complex(num.getReal().divide(den.getReal()), num.getImaginary().divide(den.getReal()));

    }

    @Override
    protected Number pow(Rational rat) {
        return null;
    }

    @Override
    protected Number pow(Real r) {
        return null;
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }


}
