package com.ua.sutty.lab7.task2;

import interfaces.task7.executor.CopyTask;

import java.io.*;
import java.nio.channels.FileChannel;

public class CopyTaskImpl implements CopyTask {

    private String source;
    private String dest;
    private int tryCount;

    @Override
    public void setSource(String s) {
        if (s == null){
            throw new NullPointerException();
        }
        try {
            this.source = s;
            new FileInputStream((source));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void setDest(String s) {
        if (s == null){
            throw new NullPointerException();
        }
        this.dest = s;
    }

    @Override
    public int getTryCount() {
        return this.tryCount;
    }

    @Override
    public void incTryCount() {
        this.tryCount++;
    }

    @Override
    public boolean execute() throws Exception {
//        try (InputStream input = new FileInputStream(source);
//             OutputStream output = new FileOutputStream(dest)) {
//            int c;
//            while ((c = input.read()) != -1) {
//                output.write(c);
//            }
//        } catch (FileNotFoundException e) {
//            throw new IllegalArgumentException(e);
//        } catch (IOException e) {
//            e.getCause();
//            e.printStackTrace();
//        }
//        return true;

        FileInputStream input;
        FileOutputStream output;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Illegal argument", e.getCause());

        }
        try (FileChannel inputChannel = input.getChannel();
             FileChannel outputChannel = output.getChannel()) {
            inputChannel.transferTo(0, inputChannel.size(), outputChannel);
        } catch (IOException e) {
            e.getCause();
        }
        return true;
    }
}
