package com.ua.sutty.lab8;

import interfaces.task8.PathClassLoader;

public class Test {

    public static void main(String[] args) {


        PathClassLoaderImpl pathClassLoader = new PathClassLoaderImpl();
        pathClassLoader.setPath("/home/NIX/suttyread/Desktop/send/4/src/main/java/com/ua/sutty/lab2/");
        try {
            pathClassLoader.loadClass("Main");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
