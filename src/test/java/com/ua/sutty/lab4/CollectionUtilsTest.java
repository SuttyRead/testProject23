package com.ua.sutty.lab4;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

import interfaces.task4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class CollectionUtilsTest {
    private static Class testingClass;

    private CollectionUtils collectionUtils = null;
    private Collection<Integer> a = null;
    private Collection<Integer> b = null;
    private Integer int1 = 1;
    private Integer int2 = 2;
    private Integer int3 = 3;

    @Before
    public void before() throws Exception {
        collectionUtils = new CollectionUtilsImpl();
        a = new ArrayList<Integer>();
        b = new ArrayList<Integer>();
    }

    @Test
    public void testUnionClear() {
        List<Integer> result = collectionUtils.union(a, b);
        assertNotNull("result should be not null", result);
        assertEquals("for empty input should be empty result", 0, result.size());
    }

    @Test
    public void testUnionNull() {
        try {
            collectionUtils.union(null, b);
            fail("if a == null should throw NullPointerException");
        } catch (NullPointerException e) {
        } catch (Exception e) {
            fail("if a == null should throw NullPointerException");
        }

        try {
            collectionUtils.union(a, null);
            fail("if b == null should throw NullPointerException");
        } catch (NullPointerException e) {
        } catch (Exception e) {
            fail("if b == null should throw NullPointerException");
        }
    }

    @Test
    public void testUnion() {
        a.add(int1);
        b.add(int2);
        b.add(int3);
        List<Integer> result = collectionUtils.union(a, b);
        assertNotNull("result should be not null", result);
        assertEquals("size should be 3 a=" + a + "b=" + b, 3, result.size());
        assertTrue("result should contains all elements a=" + a, result
            .containsAll(a));
        assertTrue("result should contains all elements b=" + b, result
            .containsAll(b));
    }

    @Test
    public void testUnionDuplicates() {
        a.add(int1);
        a.add(int2);
        b.add(int1);
        b.add(int3);
        List<Integer> result = collectionUtils.union(a, b);
        assertNotNull("result should be not null", result);
        assertEquals("size should be 4 a=" + a + "b=" + b, 4, result.size());
        assertTrue("result should contains all elements a=" + a, result
            .containsAll(a));
        assertTrue("result should contains all elements b=" + b, result
            .containsAll(b));
    }

    @Test
    public void testIntersectionNull() {
        try {
            collectionUtils.intersection(null, b);
            fail("if a == null should throw NullPointerException");
        } catch (NullPointerException e) {
        } catch (Exception e) {
            fail("if a == null should throw NullPointerException");
        }

        try {
            collectionUtils.intersection(a, null);
            fail("if b == null should throw NullPointerException");
        } catch (NullPointerException e) {
        } catch (Exception e) {
            fail("if b == null should throw NullPointerException");
        }
    }

    @Test
    public void testIntersectionClear() {
        a.add(int1);
        a.add(int2);
        b.add(int3);
        List<Integer> result = collectionUtils.intersection(a, b);
        assertNotNull("result should be not null", result);
        assertEquals("size should be 0 a=" + a + "b=" + b, 0, result.size());
    }

    @Test
    public void testIntersection() {
        a.add(int1);
        a.add(int2);
        b.add(int1);
        b.add(int3);
        List<Integer> result = collectionUtils.intersection(a, b);
        assertNotNull("result should be not null", result);
        assertEquals("size should be 2 a=" + a + "b=" + b, 2, result.size());
        assertSame("result should contains twice " + int1, result.toArray()[0],
            int1);
        assertSame("result should contains twice " + int1, result.toArray()[1],
            int1);
    }

    @Test
    public void testIntersectionWithoutDuplicateNull() {
        try {
            collectionUtils.intersectionWithoutDuplicate(null, b);
            fail("if a == null should throw NullPointerException");
        } catch (NullPointerException e) {
        } catch (Exception e) {
            fail("if a == null should throw NullPointerException");
        }

        try {
            collectionUtils.intersectionWithoutDuplicate(a, null);
            fail("if b == null should throw NullPointerException");
        } catch (NullPointerException e) {
        } catch (Exception e) {
            fail("if b == null should throw NullPointerException");
        }
    }

    @Test
    public void testIntersectionWithoutDuplicate() {
        a.add(int1);
        a.add(int2);
        b.add(int1);
        b.add(int3);
        Set<Integer> result = collectionUtils
            .intersectionWithoutDuplicate(a, b);
        assertNotNull("result should be not null", result);
        assertEquals("size should be 1 a=" + a + "b=" + b, 1, result.size());
        assertSame("result should contains only one " + int1,
            result.toArray()[0], int1);
    }

    @Test
    public void testDifferenceNull() {
        try {
            collectionUtils.difference(null, b);
            fail("if a == null should throw NullPointerException");
        } catch (NullPointerException e) {
        } catch (Exception e) {
            fail("if a == null should throw NullPointerException");
        }

        try {
            collectionUtils.difference(a, null);
            fail("if b == null should throw NullPointerException");
        } catch (NullPointerException e) {
        } catch (Exception e) {
            fail("if b == null should throw NullPointerException");
        }
    }

    @Test
    public void testDifferenceClear() {
        a.add(int1);
        a.add(int3);
        b.add(int1);
        b.add(int3);
        Collection<Integer> result = collectionUtils.difference(a, b);
        assertNotNull("result should be not null", result);
        assertEquals("size should be 0 a=" + a + "b=" + b, 0, result.size());
    }

    @Test
    public void testDifference() {
        a.add(int1);
        a.add(int2);
        b.add(int1);
        b.add(int3);
        Collection<Integer> result = collectionUtils.difference(a, b);
        assertNotNull("result should be not null", result);
        assertEquals("size should be 1 a=" + a + "b=" + b, 1, result.size());
        assertSame("result should contains only one " + int2,
            result.toArray()[0], int2);
    }

}