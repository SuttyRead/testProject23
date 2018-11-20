package com.ua.sutty.lab10;

import com.ua.sutty.lab5.ArrayCollectionImpl;
import interfaces.task5.ArrayCollection;
import interfaces.task5.ArrayIterator;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayCollectionIteratorTest {

    private ArrayCollection arrayCollection;
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
    public void testNext(){
        try {
            iterator.next();
        } catch (Exception e) {
            assertEquals(NoSuchElementException.class, e.getClass());
        }

    }

}
