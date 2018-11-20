package com.ua.sutty.lab4;


import interfaces.task4.CollectionUtils;
import interfaces.task4.MapUtils;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5,
            6, 74, 8, 9, 0, 0);
        List<Integer> integerList2 = Arrays.asList(5, 64, 7, 8, 9,
            0, 1, 0);
        CollectionUtils collectionUtils = new CollectionUtilsImpl();

        System.out.println("Union collection:");
        System.out.println(collectionUtils.union(integerList,
            integerList2) + "\n");

        System.out.println("Intersection collection");
        System.out.println(collectionUtils.intersection(integerList,
            integerList2) + "\n");

        System.out.println("Intersection without duplicate collection:");
        System.out.println(collectionUtils.intersectionWithoutDuplicate(
            integerList, integerList2) + "\n");

        System.out.println("Different collection:");
        System.out.println(collectionUtils.difference(integerList,
            integerList2) + "\n");

        MapUtils mapUtils = new MapUtilsImpl();

        System.out.println("Find combination in the text:");
        System.out.println(mapUtils.findThrees("12") + "\n");
        System.out.println(mapUtils.findThrees("URL") + "\n");
        System.out.println("hello");

    }

}
