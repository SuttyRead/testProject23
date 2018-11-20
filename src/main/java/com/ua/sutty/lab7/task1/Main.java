package com.ua.sutty.lab7.task1;

import interfaces.task7.simple.NamePrinterRunnable;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        NamePrinterRunnable namePrinterRunnable = new NamePrinterRunnableImpl();
        ReentrantLock lock = new ReentrantLock();

        namePrinterRunnable.setCount(10);
        namePrinterRunnable.setPrintName("Roman");
//        lock.lock();
        PrintStream printStream = new PrintStream("newText.txt");
//        lock.unlock();
        namePrinterRunnable.setStream(printStream);
        namePrinterRunnable.setInterval(1000);


        NamePrinterThreadImpl namePrinterThread = new NamePrinterThreadImpl();
        namePrinterThread.setCount(10);
        namePrinterThread.setPrintName("Ivan");

        PrintStream printStream2 = new PrintStream("newText.txt");

        namePrinterThread.setStream(printStream);
        namePrinterThread.setInterval(1000);
        Thread thread2 = new Thread(namePrinterRunnable);
        thread2.start();
        namePrinterThread.run();

    }

}
