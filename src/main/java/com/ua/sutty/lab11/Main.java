package com.ua.sutty.lab11;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        LoggingArrayCollection2<Integer> loggingArrayCollection = new LoggingArrayCollection2<>();
        System.out.println(loggingArrayCollection.add(1));
//        loggingArrayCollection.size();
//        loggingArrayCollection.size();
//        loggingArrayCollection.size();
//        loggingArrayCollection.size();
//        loggingArrayCollection.size();
        System.out.println(loggingArrayCollection.retainAll(Arrays.asList(1,2,3,4,5)));

    }

}
