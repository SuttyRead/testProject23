package com.ua.sutty.lab10;

import com.ua.sutty.lab5.ArrayCollectionImpl;
import interfaces.task5.ArrayCollection;
import interfaces.task5.ArrayIterator;
import org.junit.Before;

public class ArrayCollectionImplTest {

    private ArrayCollection<Double> arrayCollection = null;
    private ArrayIterator<Double> arrayIterator;
    private Double[] doubleArray = { 1d, 2d, 3d };


    @Before
    public void before() throws Exception {
        arrayCollection = new ArrayCollectionImpl<>();
    }

}
