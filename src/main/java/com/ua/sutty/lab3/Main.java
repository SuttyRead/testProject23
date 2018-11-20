package com.ua.sutty.lab3;

import interfaces.task3.StringUtils;

public class Main {

    public static void main(String[] args) {
        StringUtils stringUtils = new StringUtilsImpl();

        System.out.println(stringUtils.invert("hello"));
        String s = stringUtils.compareWords("12345",
            "789");
        System.out.println(s);
        try {
            System.out.println(stringUtils.parseDouble("1.23e.11"));
//            System.out.println(stringUtils.parseDouble(".123.563f33gfh345"));
        } catch (Exception e) {
            System.err.println("Incorrect number." +
                " Error was caused in method \"parseDouble\" at " +
                "com.ua.sutty.lab3.StringUtilsImpl.parseDouble(" +
                "StringUtils.java:37)");
            throw new IllegalArgumentException("No opportunity to transform");
        }
        StringDivImpl stringDiv = new StringDivImpl();
        System.out.println(stringDiv.div("1", "0"));
    }
}
