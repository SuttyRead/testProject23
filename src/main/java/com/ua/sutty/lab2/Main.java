package com.ua.sutty.lab2;

import interfaces.task2.FractionNumber;
import interfaces.task2.FractionNumberOperation;

public class Main {

    public static void main(String[] args) {

        FractionNumber firstFractionNumber = new FractionNumberImpl(10, 5);
        FractionNumber secondFractionNumber = new FractionNumberImpl(10, 2);
        FractionNumberOperation fno = new FractionalNumberOperationImpl();


        FractionNumber fractionNumberAfterAdd = fno.add(firstFractionNumber,
            secondFractionNumber);
        System.out.println("2 + 5 = " + fractionNumberAfterAdd.value());

        FractionNumber fractionNumberAfterDiv = fno.div(firstFractionNumber,
            secondFractionNumber);
        System.out.println("2 / 5 = " + fractionNumberAfterDiv.value());

        FractionNumber fractionNumberAfterMul = fno.mul(firstFractionNumber,
            secondFractionNumber);
        System.out.println("2 * 5 = " + fractionNumberAfterMul.value());

        FractionNumber fractionNumberAfterSub = fno.sub(firstFractionNumber,
            secondFractionNumber);
        System.out.println("2 - 5 = " + fractionNumberAfterSub.value());


    }

}
