package com.ua.sutty.lab4;

import static junit.framework.Assert.*;
import static junit.framework.Assert.assertNotNull;
import interfaces.task4.MapUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class MapUtilsTest {

    private static Class testingClass;
    private MapUtils mapUtils = null;



    @Before
    public void before() throws Exception {
        mapUtils = new MapUtilsImpl();

    }


    @Test
    public void testNull() {
        try {
            mapUtils.findThrees(null);
            fail("if str == null should throw NullPointerException");

        } catch (NullPointerException e) {

        } catch (Exception e) {
            fail("if str == null should throw NullPointerException");

        }

    }


    @Test
    public void testClear() {
        Map<String, Integer> result = mapUtils.findThrees("");
        assertNotNull("result should be not null", result);
        assertEquals("size should be 0 for ''", 0, result.size());
    }


    @Test
    public void test1() {
        String str = "12";
        Map<String, Integer> result = mapUtils.findThrees(str);
        assertEquals("'" + str + "' size should be 0 for '12'", 0, result
            .size());
    }


    @Test
    public void test2() {
        String str = "123";
        Map<String, Integer> result = mapUtils.findThrees(str);
        assertEquals("'" + str + "' size should be 1", 1, result.size());
        assertEquals("'" + str + "' result should contain 1 for '123'",
            new Integer(1), result.get("123"));

    }


    @Test
    public void test3() {
        String str = "1234";
        Map<String, Integer> result = mapUtils.findThrees(str);
        assertEquals("'" + str + "' size should be 2", 2, result.size());
        assertEquals("'" + str + "' result should contain 1 for '123'",
            new Integer(1), result.get("123"));
        assertEquals("'" + str + "' result should contain 1 for '234'",
            new Integer(1), result.get("234"));

    }


    @Test
    public void test4() {
        String str = "1234 123";
        Map<String, Integer> result = mapUtils.findThrees(str);
        assertEquals("'" + str + "' size should be 2", 2, result.size());
        assertEquals("'" + str + "' result should contain 2 for '123'",
            new Integer(2), result.get("123"));
        assertEquals("'" + str + "' result should contain 1 for '234'",
            new Integer(1), result.get("234"));

    }

    @Test
    public void test5() {
        String str = "1234 123_234";
        Map<String, Integer> result = mapUtils.findThrees(str);
        assertEquals("'" + str + "' size should be 2", 2, result.size());
        assertEquals("'" + str + "' result should contain 2 for '123'",
            new Integer(2), result.get("123"));
        assertEquals("'" + str + "' result should contain 2 for '234'",
            new Integer(2), result.get("234"));

    }


    @Test
    public void test6() {
        String str = "1234 123_234*12";
        Map<String, Integer> result = mapUtils.findThrees(str);
        assertEquals("'" + str + "' size should be 2", 2, result.size());
        assertEquals("'" + str + "' result should contain 2 for '123'",
            new Integer(2), result.get("123"));
        assertEquals("'" + str + "' result should contain 2 for '234'",
            new Integer(2), result.get("234"));

    }

}