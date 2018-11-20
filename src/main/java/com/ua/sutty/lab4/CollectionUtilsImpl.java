package com.ua.sutty.lab4;

import interfaces.task4.CollectionUtils;

import java.util.*;

public class CollectionUtilsImpl implements CollectionUtils {

    public CollectionUtilsImpl() {
    }

    @Override
    public List<Integer> union(Collection<Integer> collection,
                               Collection<Integer> collection1) {
        List<Integer> integerList = new ArrayList<>();
        integerList.addAll(collection);
        integerList.addAll(collection1);
        return integerList;
    }

    @Override
    public List<Integer> intersection(Collection<Integer> collection,
                                      Collection<Integer> collection1) {
        List<Integer> newIntegerList = new ArrayList<>();
        List<Integer> integerList1 = new ArrayList<>(collection);
        List<Integer> integerList2 = new ArrayList<>(collection1);
        for (int i = 0; i < integerList1.size(); i++) {
            for (int j = 0; j < integerList2.size(); j++) {
                if (integerList1.get(i).equals(integerList2.get(j))) {
                    newIntegerList.add(integerList1.get(i));
                    newIntegerList.add(integerList1.get(i));
                }
            }
        }
        return newIntegerList;
    }

    @Override
    public Set<Integer> intersectionWithoutDuplicate(
        Collection<Integer> collection, Collection<Integer> collection1) {
        List<Integer> newIntegerList = new ArrayList<>();
        List<Integer> integerList1 = new ArrayList<>(collection);
        List<Integer> integerList2 = new ArrayList<>(collection1);
        for (int i = 0; i < integerList1.size(); i++) {
            for (int j = 0; j < integerList2.size(); j++) {
                if (integerList1.get(i).equals(integerList2.get(j))) {
                    newIntegerList.add(integerList1.get(i));
                    break;
                }
            }
        }
        return new HashSet<>(newIntegerList);
    }

    @Override
    public Collection<Integer> difference(Collection<Integer> collection,
                                          Collection<Integer> collection1) {
        List<Integer> newIntegerList = new ArrayList<>();
        List<Integer> integerList1 = new ArrayList<>(collection);
        List<Integer> integerList2 = new ArrayList<>(collection1);
        for (int i = 0; i < integerList1.size(); i++) {
            int k = 0;
            for (int j = 0; j < integerList2.size(); j++) {
                if (integerList1.get(i).equals(integerList2.get(j))) {
                    k++;
                }
            }
            if (k == 0) {
                newIntegerList.add(integerList1.get(i));
            }
        }
        return newIntegerList;
    }

}
