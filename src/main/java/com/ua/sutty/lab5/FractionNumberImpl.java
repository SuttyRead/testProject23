package com.ua.sutty.lab5;

import interfaces.task2.FractionNumber;

public class FractionNumberImpl implements FractionNumber {

    private int dividend;

    private int divisor;

    public FractionNumberImpl() {
    }

    public FractionNumberImpl(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("It's impossible " +
                "to divide by zero");
        }
        this.dividend = dividend;
        this.divisor = divisor;
    }

    @Override
    public void setDividend(int i) {
        this.dividend = i;
    }

    @Override
    public int getDividend() {
        return this.dividend;
    }

    @Override
    public void setDivisor(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("It's impossible " +
                "to divide by zero");
        }
        this.divisor = i;
    }

    @Override
    public int getDivisor() {
        return this.divisor;
    }

    @Override
    public double value() {
        return (double) this.dividend / (double) this.divisor;
    }

    @Override
    public String toStringValue() {
        return dividend + "/" + divisor;
    }

}
