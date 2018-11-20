package com.ua.sutty.lab5;

import interfaces.task2.FractionNumber;
import interfaces.task2.FractionNumberOperation;
import interfaces.task5.ArrayCollection;

public class Main {

    public static void main(String[] args) {

        ArrayCollection<FractionNumber> arrayCollection = new ArrayCollectionImpl<>();
        FractionNumber fractionNumber1 = new FractionNumberImpl(10, 2);
        FractionNumber fractionNumber2 = new FractionNumberImpl(20, 2);
        FractionNumber fractionNumber3 = new FractionNumberImpl(30, 2);
        FractionNumber fractionNumber4 = new FractionNumberImpl(40, 2);
        arrayCollection.add(fractionNumber1);
        arrayCollection.add(fractionNumber2);
        arrayCollection.add(fractionNumber3);
        arrayCollection.add(fractionNumber4);

        FractionNumber fnr = new FractionNumberImpl(0, 1);
        FractionNumberOperation fno = new FractionalNumberOperationImpl();

        for (FractionNumber fractionNumber : arrayCollection) {
            fnr = fno.add(fnr, fractionNumber);
        }

        System.out.println(fnr.value());

    }

}
