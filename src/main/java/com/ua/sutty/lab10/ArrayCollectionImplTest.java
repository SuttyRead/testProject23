package com.ua.sutty.lab10;

import com.ua.sutty.lab5.ArrayCollectionImpl;
import interfaces.task5.ArrayCollection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class ArrayCollectionImplTest {

    private ArrayCollection<Integer> arrayCollection = null;
    private Integer[] array = {1, 2, 3};

    @Before
    public void before() {
        arrayCollection = new ArrayCollectionImpl<>();
    }

    @Test
    public void clear() {
        arrayCollection.setArray(array);
        int size1 = arrayCollection.size();
        arrayCollection.clear();
        int size2 = arrayCollection.size();
        if (size1 == size2){
            Assert.fail("Don't work clear");
        }
    }

    @Test
    public void contains() {
        arrayCollection.setArray(array);
        Assert.assertTrue("check contains collection",
            arrayCollection.contains(array[0]));
    }

    @Test
    public void add() {
        Assert.assertTrue("Check add to collection", arrayCollection.add(array[0]));
    }

    @Test
    public void remove() {
        arrayCollection.setArray(array);
        Assert.assertTrue("Check remove with collection", arrayCollection.remove(array[0]));
    }

    @Test
    public void isEmpty() {
        Assert.assertEquals("check collection empty", 0,
            arrayCollection.size());
        arrayCollection.setArray(array);
        Assert.assertTrue("check collection empty", !arrayCollection.isEmpty());
    }

    @Test
    public void addAll() {
        arrayCollection.addAll(Arrays.asList(array));
        Assert.assertArrayEquals("check addAll in collection ",
            array, arrayCollection.getArray());
    }

    @Test
    public void retainAll() {
        arrayCollection.setArray(array);
        Integer[] array2 = {1, 2, 4};
        arrayCollection.retainAll(Arrays.asList(array2));
        Assert.assertEquals("check collection after", 2,
            arrayCollection.size());
    }

    @Test
    public void containsAll() {
        arrayCollection.setArray(array);
        Assert.assertTrue(arrayCollection.containsAll(Arrays.asList(array)));
        Assert.assertArrayEquals("check containsAll collection",
            array, arrayCollection.getArray());
    }

    @Test
    public void toArray() {
        arrayCollection.setArray(array);
        Assert.assertArrayEquals("check toArray collection",
            array, arrayCollection.toArray());
    }

    @Test
    public void removeAll() {
        arrayCollection.setArray(array);
        int size1 = arrayCollection.size();
        arrayCollection.removeAll(arrayCollection);
        int size2 = arrayCollection.size();
        if (size1 == size2){
            Assert.fail("Don't work removeAll");
        }
    }

}