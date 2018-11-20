package com.ua.sutty.lab3;

import interfaces.task3.StringDiv;
import interfaces.task3.StringUtils;

public class StringDivImpl implements StringDiv {

    public StringDivImpl() {
    }

    @Override
    public double div(String s, String s1) {

        if (s == null || s1 == null) {
            throw new NullPointerException("Don't have necessary ");
        }

        StringUtils stringUtils = new StringUtilsImpl();
        double firstVariable = stringUtils.parseDouble(s);
        double secondVariable = stringUtils.parseDouble(s1);
        if (secondVariable == 0) {
            throw new ArithmeticException("It's impossible to divide by zero");
        }
        return firstVariable / secondVariable;
    }

}
