package com.ua.sutty.lab6;

import interfaces.task6.IOUtils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        IOUtils ioUtils = new IOUtilsImpl();

        //Check change in file
        try (FileReader fileReader = new FileReader("text.txt");
             FileWriter fileWriter = new FileWriter("copy_text.txt")) {
            ioUtils.replaceChars(fileReader, fileWriter, "123", "abc");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Find file
        System.out.println(Arrays.toString(ioUtils.findFiles(
            "/home/NIX/suttyread/Desktop", "jar")));

        //Three methods copy file
        ioUtils.copyFile("text.txt", "copyText.txt");
        ioUtils.copyFileBuffered(new File("text.txt"), new File(
            "copyText.txt"));
        ioUtils.copyFileBest("text.txt", "copyText.txt");

    }

}
