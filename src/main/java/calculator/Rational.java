package calculator;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class Rational extends Number implements Expression, Comparable<Rational> {

    protected BigInteger numerator;
    protected BigInteger denominator;
    protected MathContext mc = new MathContext(10, RoundingMode.HALF_UP);

    /**
     * Constructs a Rational integer representing 1.
     */
    public /*constructor*/ Rational() {
        numerator = BigInteger.ZERO;
        denominator = BigInteger.ONE;
    }

    /**
     * Constructs a Rational integer representing the given integer.
     * @param n the Integ to represent
     */
    public /*constructor*/ Rational(Integ n) {
        numerator = n.getValue();
        denominator = BigInteger.ONE;
    }

    @Override
    public Real toReal() {
        return new Real(this);
    }

    /**
     * Creates a Rational number with the numerator and denominator set in parameters.
     * @param numerator the numerator
     * @param denominator the denominator
     */
    protected /*constructor*/ Rational(BigInteger numerator, BigInteger denominator) {
        super();
        this.numerator = numerator;
        this.denominator = denominator;

        if (denominator.compareTo(BigInteger.ZERO) < 0) {
            this.numerator = this.numerator.negate();
            this.denominator = this.denominator.negate();
        }
        simplify();
    }

    /**
     * Creates a Rational corresponding number
     * @param number the number to store
     */
    public /*constructor*/ Rational(long number) {
        this(BigInteger.valueOf(number), BigInteger.ONE);
    }

    public /*constructor*/ Rational(long numerator, long denominator) {
        this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
    }

    public /*constructor*/ Rational(String numerator, String denominator) {
        this(new BigInteger(numerator), new BigInteger(denominator));
    }

    /**
     * The representation of a fraction is typically using a simplified version. This method simplifies a Rational.
     */
    private void simplify() {
        if (!denominator.equals(BigInteger.ZERO)) {
            BigInteger gcd = numerator.gcd(denominator);
            numerator = numerator.divide(gcd);
            denominator = denominator.divide(gcd);
        }
    }

    /**
     * Returns the value of the numerator.
     * @return the numerator
     */
    /*package*/ BigInteger getNumerator() {
        return numerator;
    }

    /**
     * Returns the value of the denominator.
     * @return denominator
     */
    /*package*/ BigInteger getDenominator() {
        return denominator;
    }

    @Override
    public Number negate() {
        return new Rational(numerator.negate(), denominator);
    }

    @Override
    protected Number add(Integ i) {
        return i.add(this);
    }


    @Override
    protected Number add(Rational rat) {
        return new Rational(numerator.multiply(rat.denominator).add(rat.numerator.multiply(denominator)),
                denominator.multiply(rat.denominator));
    }

    @Override
    protected Number add(Real r) {
        return r.add(this);
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
        return new Rational(numerator.multiply(rat.numerator),
                denominator.multiply(rat.denominator));
    }

    @Override
    protected Number multiply(Real r) {
        return r.multiply(this);
    }

    @Override
    protected Number multiply(Complex c) {
        return c.multiply(this);
    }

    @Override
    protected Number divide(Integ i) {
        return this.divide(new Rational(i));
    }

    @Override
    protected Number divide(Rational rat) {
        if (rat.equals(new Rational(0))) {
            throw new ArithmeticException(); // TODO do it better
        }
        return multiply(new Rational(rat.denominator, rat.numerator));
    }

    @Override
    protected Number divide(Real r) {
        Real us = new Real(this);
        return us.divide(r);
    }

    @Override
    protected Number divide(Complex c) {
        Complex us = new Complex(this.toReal().getValue());
        return us.divide(c);
    }

    @Override
    protected Number pow(Rational rat) {
        return new Real(BigDecimalMath.pow(toReal().getValue(), rat.toReal().getValue(), MathContext.DECIMAL128)); //TODO Implement while staying in Rationals
    }

    @Override
    protected Number pow(Real r) {
        return new Real(BigDecimalMath.pow(toReal().getValue(), r.getValue(), MathContext.DECIMAL128));
    }

    @Override
    public String toString() {
        String representation = numerator.toString();
        if (!denominator.equals(BigInteger.ONE)) {
            representation += "/" + denominator;
        }
        return representation;
    }

    //Two MyNumber expressions are equal if the values they contain are equal
    @Override
    public boolean equals(Object o) {
        // No object should be equal to null (not including this check can result in an exception if a MyNumber is tested against null)
        if (o == null) return false;

        // If the object is compared to itself then return true
        if (o == this) {
            return true;
        }

        if (o instanceof Rational r) {
            return numerator.equals(r.numerator) && denominator.equals(r.denominator); // TODO handle multiples
        } else {
            // If the object is of another type then return false
            return false;
        }

    }

    // The method hashCode() needs to be overridden if the equals method is overridden; otherwise there may be problems when you use your object in hashed collections such as HashMap, HashSet, LinkedHashSet
    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public int compareTo(Rational o) {
        int aSig = numerator.signum();
        int bSig = o.numerator.signum();

        if (aSig != bSig) {
            return (aSig > bSig) ? 1 : -1;
        }
        if (aSig == 0) { // bSig is also 0
            return 0;
        }

        return numerator.multiply(o.denominator).compareTo(denominator.multiply(numerator));
    }
}