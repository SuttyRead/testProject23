package com.ua.sutty.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        CollectionUtilsImpl collectionUtils = new CollectionUtilsImpl();
        Collection<Integer> a = new ArrayList<>();
        Collection<Integer> b = new ArrayList<>();
        Integer int1 = 1;
        Integer int2 = 2;

        Integer int3 = 3;
        a.add(int1);
        a.add(int2);
        b.add(int1);
        b.add(int3);
        List<Integer> result = collectionUtils.intersection(a, b);
        System.out.println(result.size());
    }

}
