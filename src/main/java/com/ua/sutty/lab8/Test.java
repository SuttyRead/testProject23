package com.ua.sutty.lab8;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException {


//        PathClassLoaderImpl pathClassLoader = new PathClassLoaderImpl();
//        pathClassLoader.setPath("/home/NIX/suttyread/Desktop/send/4/src/main/java/com/ua/sutty/lab2/");
//        try {
//            pathClassLoader.loadClass("Main");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        PathClassLoaderImpl classLoaderSub = new PathClassLoaderImpl();
        classLoaderSub.setPath(
            "/home/NIX/suttyread/IdeaProjects/MavenJar/target/classes");
        Class<?> loadClass = classLoaderSub
            .loadClass("Main");
        Arrays.stream(loadClass.getMethods()).forEach(System.out::println);

    }

}
