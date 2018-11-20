package com.ua.sutty.lab8;

import interfaces.task8.CyclicCollection;
import interfaces.task8.CyclicItem;
import interfaces.task8.SerializableUtils;

import java.io.*;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        //Initialization
        CyclicCollection cyclicCollection = new CyclicCollectionImpl();
        CyclicItem cyclicItem1 = new CyclicItemImpl(10);
        CyclicItem cyclicItem2 = new CyclicItemImpl(20);
        CyclicItem cyclicItem3 = new CyclicItemImpl(30);
        CyclicItem cyclicItem4 = new CyclicItemImpl(40);
        cyclicCollection.add(cyclicItem1);
        cyclicCollection.add(cyclicItem2);
        cyclicCollection.add(cyclicItem3);

        System.out.println("First element = " + cyclicCollection.getFirst());

        //Insert element cyclicItem4 after cyclicItem2
        cyclicCollection.insertAfter(cyclicItem2, cyclicItem4);
        //Checked insert element after
        System.out.println(cyclicCollection.getFirst().nextItem().nextItem());

        //Remove element
        cyclicCollection.remove(cyclicItem4);
        //Checked remove element
        System.out.println(cyclicCollection.getFirst().nextItem().nextItem()
            .nextItem().nextItem().nextItem().nextItem());

        //Serialization
        SerializableUtils serializableUtils = new SerializableUtilsImpl();
        OutputStream outputStream = null;
        InputStream inputStream = null;
        CyclicCollection newCyclicCollection = null;
        try {
            outputStream = new FileOutputStream("cyclic.txt");
            inputStream = new FileInputStream("cyclic.txt");
            serializableUtils.serialize(outputStream, cyclicCollection);

            newCyclicCollection = (CyclicCollection) serializableUtils
                .deserialize(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(outputStream).close();
                Objects.requireNonNull(inputStream).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(newCyclicCollection);
        System.out.println(Objects.requireNonNull(newCyclicCollection)
            .getFirst().nextItem().nextItem().nextItem());
    }

}
