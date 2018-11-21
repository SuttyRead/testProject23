package com.ua.sutty.lab10;

import com.ua.sutty.lab5.ArrayCollectionImpl;
import interfaces.task5.ArrayCollection;
import interfaces.task5.ArrayIterator;
import org.junit.Before;
import org.junit.Test;


import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ArrayCollectionIteratorTest {

    private ArrayCollection<Double> arrayCollection;
    private ArrayIterator iterator;
    private Double[] doubleArray = {1d, 2d, 3d};

    @Before
    public void before() throws Exception {
        arrayCollection = new ArrayCollectionImpl<>();
        iterator = (ArrayIterator) arrayCollection.iterator();
    }

    @Test
    public void newTestNext(){
        arrayCollection.setArray(doubleArray);
        assertEquals(1.0, iterator.next());
        assertTrue(iterator.hasNext());
    }

    @Test
    public void testHasNext(){
        assertFalse("check iterator", arrayCollection.iterator().hasNext());
        arrayCollection.add(1.0);
        assertTrue("check iterator", iterator.hasNext());
    }

    @Test
    public void testNext(){
        try {
            iterator.next();
            fail("Don't have next element");
        }catch (NoSuchElementException e){

        }
    }

    @Test
    public void testRemoveWhenEmpty() {
        try {
            arrayCollection.iterator().remove();
            fail("should be throw IllegalStateException");
        } catch (IllegalStateException e) {
        }
    }

}
