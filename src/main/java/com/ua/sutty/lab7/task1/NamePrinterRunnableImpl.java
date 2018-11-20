package com.ua.sutty.lab7.task1;

import interfaces.task7.simple.NamePrinterRunnable;

import java.io.PrintStream;

public class NamePrinterRunnableImpl implements NamePrinterRunnable {

    private String printName;
    private PrintStream printStream;
    private long interval;
    private int count;

    @Override
    public void setPrintName(String s) {
        if (s == null){
            throw new NullPointerException();
        }

        if (s.equals("")){
            throw new IllegalArgumentException();
        }

        this.printName = s;
    }

    @Override
    public void setStream(PrintStream printStream) {
        if (printStream == null){
            throw new NullPointerException();
        }
        this.printStream = printStream;
    }

    @Override
    public void setInterval(long l) {
        if (l == 0){
            throw new IllegalArgumentException();
        }
        this.interval = l;
    }

    @Override
    public void setCount(int i) {
        if (i == 0){
            throw new IllegalArgumentException();
        }
        this.count = i;
    }

    @Override
    public void run() {
        synchronized (this) {


            try {
                for (int i = 0; i < count; i++) {
                    printStream.append(printName);
//                    printStream.flush();
                    Thread.sleep(interval);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                printStream.close();
            }
        }

    }
}
