package com.ua.sutty.lab7;

import static junit.framework.Assert.assertEquals;

import com.ua.sutty.lab7.task2.SumTaskImpl;
import interfaces.task7.executor.Task;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TaskTest {
    private static Class testingClass;

    private Task task;

    @Before
    public void before() throws Exception {
        task = new SumTaskImpl();
    }

    @After
    public void after() {
    }

    @Test
    public void testTryCount() throws Exception {
        assertEquals("tryCount should be 0 after create", 0, task.getTryCount());
        task.incTryCount();
        assertEquals("tryCount should be 1 after 1 incTryCount", 1, task
            .getTryCount());
    }
}