package com.ua.sutty.lab3;

import interfaces.task3.StringUtils;

public class StringUtilsImpl implements StringUtils {

    public StringUtilsImpl() {
    }

    @Override
    public String invert(String s) {
        if (s == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    @Override
    public String compareWords(String s, String s1) {
        if (s == null || s1 == null) {
            throw new NullPointerException("String is null");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int k = 0;
            for (int j = 0; j < s1.length(); j++) {
                if (s.charAt(i) == s1.charAt(j)) {
                    k++;
                }
            }
            if (k == 0) {
                sb.append(s.charAt((i)));
            }
        }
        return sb.toString();
    }

    @Override
    public double parseDouble(String s) throws RuntimeException {
        double result;
        try {
            String[] strings = s.split(" ");
            result = strings.length > 0 ? Double.parseDouble(strings[0]) : Double.parseDouble(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Wrong number", e);
        }
        return result;
    }

}
