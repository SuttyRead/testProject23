package com.ua.sutty.lab5;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ArrayCollectionImplTest {

    private ArrayCollectionImpl<Double> arrayCollection;
    private Integer[] doubles = new Integer[] {1, 2, 3};
    private List<Double> arrayList = Arrays.asList(1.4, 1.6, 1.8, 1.6);

    @Before
    public void before() throws Exception {
        arrayCollection = new ArrayCollectionImpl<>();
    }

    @Test
    public void getArray() {
        assertNotNull("getArray should not return null after create",
            arrayCollection.getArray());
        arrayCollection.setArray(doubles);
        assertEquals(arrayCollection.getArray(), doubles);
    }

    @Test
    public void setArray() {
        arrayCollection.setArray(doubles);
        assertEquals(arrayCollection.getArray(), doubles);
        try {
            arrayCollection.setArray(null);
            fail("Array can not be null");
        } catch (NullPointerException e) {

        }
    }

    @Test
    public void size() {
        assertEquals(0, arrayCollection.size());
        arrayCollection.add(1.0);
        arrayCollection.add(2.0);
        arrayCollection.add(3.0);
        arrayCollection.add(4.0);
        assertEquals(4, arrayCollection.size());
    }

    @Test
    public void isEmpty() {
        assertTrue(arrayCollection.isEmpty());
        arrayCollection.add(1.0);
        assertFalse(arrayCollection.isEmpty());
    }

    @Test
    public void add() {
        assertTrue(arrayCollection.add(1.8));
        assertEquals(1.8, arrayCollection.getArray()[0]);
        assertNotNull(arrayCollection.add(null));
        assertTrue(arrayCollection.add(null));
    }

    @Test
    public void remove() {
        arrayCollection.add(4.0);
        arrayCollection.add(4.0);
        arrayCollection.add(4.0);
        arrayCollection.add(4.0);
        arrayCollection.remove(4.0);
        assertEquals(3, arrayCollection.size());
        assertNotNull(arrayCollection.remove(1.0));
    }

    @Test
    public void addAll() {
        arrayCollection.addAll(arrayList);
        assertEquals(arrayList.toArray(), arrayCollection.getArray());
        try {
            arrayCollection.addAll(null);
            fail();
        } catch (NullPointerException e) {
            System.out.println("Can't addAll - null");
        }
    }


    @Test
    public void removeAll() {
        arrayCollection.add(4.0);
        arrayCollection.add(4.0);
        arrayCollection.add(4.0);
        arrayCollection.add(4.0);
        arrayCollection.removeAll(arrayCollection);
        assertEquals(0, arrayCollection.size());
        assertNotNull(arrayCollection.remove(1.0));
    }
}