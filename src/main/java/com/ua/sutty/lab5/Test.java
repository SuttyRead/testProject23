package com.ua.sutty.lab5;

import interfaces.task5.ArrayCollection;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        ArrayCollection<Double> arrayCollection = new ArrayCollectionImpl<>();
//        arrayCollection.add(null);
//        System.out.println(Arrays.toString(arrayCollection.getArray()));
//        System.out.println(arrayCollection.getArray().length);
//        arrayCollection.containsAll(null);

//        Double[] doubleArray = { 1d, 2d, 3d };
//        arrayCollection.setArray(doubleArray);
//        System.out.println(Arrays.equals(doubleArray, arrayCollection.getArray()));
//        ArrayList arrayList = new ArrayList();

        System.out.println(Arrays.toString(arrayCollection.getArray()));
    }

}
