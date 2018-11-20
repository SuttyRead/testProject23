package com.ua.sutty.lab7.task2;

import interfaces.task7.executor.Executor;
import interfaces.task7.executor.Task;
import interfaces.task7.executor.TasksStorage;

public class ExecutorImpl implements Executor {

    private boolean isStart = false;

    private TasksStorage tasksStorage;

    public ExecutorImpl() {
    }

    public ExecutorImpl(TasksStorage tasksStorage) {
        this.tasksStorage = tasksStorage;
    }

    @Override
    public void setStorage(TasksStorage tasksStorage) {
        this.tasksStorage = tasksStorage;
    }

    @Override
    public TasksStorage getStorage() {
        return this.tasksStorage;
    }

    @Override
    public void start() {
        if (getStorage() == null) {
            throw new NullPointerException();
        }
        if (isStart) {
            throw new IllegalStateException();
        }
        isStart = true;
        Thread thread = new Thread(() -> {
            while (isStart) {
                Task task = tasksStorage.get();
                if (task == null){
                    throw new NullPointerException();
                }
                try {
                    if (!task.execute()) {
                        returnBackTask(task);
                    }
                    Thread.sleep(100);
                } catch (Exception e) {
                    returnBackTask(task);
                }
            }
        });
        thread.start();
    }

    @Override
    public void stop() {
        if (!isStart) {
            throw new IllegalStateException();
        }
        Thread.currentThread().interrupt();
        isStart = false;
    }

    private void returnBackTask(Task task) {
        if (task.getTryCount() < 5) {
            tasksStorage.add(task);
        }else {
            throw new IllegalArgumentException();
        }
    }

}
