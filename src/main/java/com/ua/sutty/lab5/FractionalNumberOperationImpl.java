package com.ua.sutty.lab5;

import interfaces.task2.FractionNumber;
import interfaces.task2.FractionNumberOperation;

public class FractionalNumberOperationImpl implements FractionNumberOperation {

    public FractionalNumberOperationImpl() {
    }

    @Override
    public FractionNumber add(FractionNumber fn, FractionNumber fn1) {
        int dividend = fn.getDividend() * fn1.getDivisor() +
            fn1.getDividend() * fn.getDivisor();
        int divisor = fn.getDivisor() * fn1.getDivisor();
        return new FractionNumberImpl(dividend, divisor);
    }

    @Override
    public FractionNumber sub(FractionNumber fn, FractionNumber fn1) {
        int dividend = fn.getDividend() * fn1.getDivisor() -
            fn1.getDividend() * fn.getDivisor();
        int divisor = fn.getDivisor() * fn1.getDivisor();
        return new FractionNumberImpl(dividend, divisor);
    }

    @Override
    public FractionNumber mul(FractionNumber fn, FractionNumber fn1) {
        int dividend = fn.getDividend() * fn1.getDividend();
        int divisor = fn.getDivisor() * fn1.getDivisor();
        return new FractionNumberImpl(dividend, divisor);
    }

    @Override
    public FractionNumber div(FractionNumber fn, FractionNumber fn1) {
        int dividend = fn.getDividend() * fn1.getDivisor();
        int divisor = fn.getDivisor() * fn1.getDividend();
        return new FractionNumberImpl(dividend, divisor);
    }
}
