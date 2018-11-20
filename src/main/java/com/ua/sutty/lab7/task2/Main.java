package com.ua.sutty.lab7.task2;

import interfaces.task7.executor.CopyTask;
import interfaces.task7.executor.Executor;
import interfaces.task7.executor.SumTask;
import interfaces.task7.executor.TasksStorage;

public class Main {

    public static void main(String[] args) {

//        SumTask sumTask = new SumTaskImpl();
////        sumTask.setCount(1000);
//        sumTask.setMax(1000000000);
//        System.out.println(sumTask.getRandom());
//
//        TasksStorage tasksStorage = new TasksStorageImpl();
//        Executor executor = new ExecutorImpl(tasksStorage);
//        System.out.println(sumTask.getResult());
//
//        Thread thread = new Thread(() ->{
//
//        });

        CopyTask copyTask = new CopyTaskImpl();

        copyTask.setSource(System.getProperty("java.io.tmpdir"));
        System.out.println(System.getProperty("java.io.tmpdir"));

    }

}
