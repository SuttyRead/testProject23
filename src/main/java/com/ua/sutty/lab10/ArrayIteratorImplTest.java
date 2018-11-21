package com.ua.sutty.lab10;

import com.ua.sutty.lab5.ArrayCollectionImpl;
import interfaces.task5.ArrayCollection;
import interfaces.task5.ArrayIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import junit.framework.TestCase;

public class ArrayIteratorImplTest extends TestCase {

    private ArrayCollection<Double> arrayCollection;
    private ArrayIterator iterator;
    private Double[] doubleArray = {1d, 2d, 3d};

    public void setUp() throws Exception {
        arrayCollection = new ArrayCollectionImpl<>();
        iterator = (ArrayIterator) arrayCollection.iterator();
    }

    public void tearDown() throws Exception {
        arrayCollection.setArray(doubleArray);
    }

    public void testNextAfterSetArray(){
        arrayCollection.setArray(doubleArray);
        assertEquals(1.0, iterator.next());
        assertTrue(iterator.hasNext());
    }

    public void testHasNext() {
        assertFalse("check iterator", arrayCollection.iterator().hasNext());
        arrayCollection.add(1.0);
        assertTrue("check iterator", iterator.hasNext());
    }

    public void testNext() {
        try {
            iterator.next();
            fail("Don't have next element");
        }catch (NoSuchElementException e){

        }
    }

    public void testNextWhenCollectionEmpty() {
        assertEquals(0, arrayCollection.size());
        Iterator iterator = arrayCollection.iterator();
        try {
            iterator.next();
            fail("should threw NoSuchElementException");
        } catch (NoSuchElementException e) {
            //
        }
    }

    public void testRemoveWhenEmpty() {
        try {
            arrayCollection.iterator().remove();
            fail("should be throw IllegalStateException");
        } catch (IllegalStateException e) {

        }
    }
}