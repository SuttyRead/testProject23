package com.ua.sutty.lab6;


import interfaces.task6.IOUtils;

import java.io.File;

public class Test {

    public static void main(String[] args) {


        String sourceFileName = "source.dat";
        String destFileName = "dest.dat";
        String sourseFilePath = System.getProperty("java.io.tmpdir") + File.separator
            + sourceFileName;
        String destFilePath = System.getProperty("java.io.tmpdir") + File.separator
            + destFileName;

        System.out.println(System.getProperty("java.io.tmpdir"));

        IOUtils ioUtils = new IOUtilsImpl();

        ioUtils.copyFileBest(System.getProperty("java.io.tmpdir"),
            destFilePath);

    }

}
