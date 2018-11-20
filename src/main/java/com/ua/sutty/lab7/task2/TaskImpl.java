package com.ua.sutty.lab7.task2;

import interfaces.task7.executor.Task;

public class TaskImpl implements Task {

    private int count;
    private boolean isDone;

    @Override
    public int getTryCount() {
        return this.count;
    }

    @Override
    public void incTryCount() {
        this.count++;
    }

    @Override
    public boolean execute() throws Exception {
        if (count >= 5){
            isDone = true;
        }
        return false;
    }
}
