package com.ua.sutty.lab7.task2;

import interfaces.task7.executor.Task;
import interfaces.task7.executor.TasksStorage;

import java.util.ArrayDeque;
import java.util.Queue;

public class TasksStorageImpl implements TasksStorage {

    private  Queue<Task> queue = new ArrayDeque<>();

    @Override
    public void add(Task task) {
        synchronized (this){
            queue.add(task);
        }
    }

    @Override
    public Task get() {
        synchronized (this){
            if (count() == 0){
                return null;
            }
            return queue.remove();
        }
    }

    @Override
    public int count() {
        return queue.size();
    }

}
