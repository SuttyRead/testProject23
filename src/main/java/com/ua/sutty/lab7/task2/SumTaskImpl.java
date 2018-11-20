package com.ua.sutty.lab7.task2;

import interfaces.task7.executor.SumTask;

import java.math.BigInteger;
import java.util.Random;

public class SumTaskImpl implements SumTask {

    private int tryCount;
    private int count;
    private long max;
    private BigInteger result;

    @Override
    public void setCount(int i) {
        synchronized (this){
            this.count = i;
        }
    }

    @Override
    public void setMax(long l) {
        if (l == 0){
            throw new IllegalArgumentException();
        }
        this.max = l;
    }

    @Override
    public BigInteger getRandom() {
        Random random = new Random();
        BigInteger b = new BigInteger(String.valueOf(max));
        BigInteger bigInteger = new BigInteger(b.bitLength(), random);
        while (bigInteger.compareTo(b) >= 0) {
            bigInteger = new BigInteger(b.bitLength(), random);
        }
        return bigInteger;
    }

    @Override
    public BigInteger getResult() {
        return getRandom().add(getRandom());
    }

    @Override
    public int getTryCount() {
        return this.tryCount;
    }

    @Override
    public void incTryCount() {
        this.tryCount++;
    }

    @Override
    public boolean execute() throws Exception {
        if (max != 0){
            getResult();
            return true;
        }
        if (count == 0){
            return true;
        }

        return false;
    }

}
