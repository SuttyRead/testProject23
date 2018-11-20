package com.ua.sutty.lab1.task_3;

import com.ua.sutty.lab1.task_2.Circle;
import com.ua.sutty.lab1.task_2.Shape;
import com.ua.sutty.lab1.task_2.Triangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Main class with operations over Shape(generate shape, define shape)
 * @autor Roman Yaremenko
 * @version 0.1
 */
public class Main {

    /**
     * Main method for call other methods
     */
    public static void main(String[] args) {

        Shape[] someShape = generateShapes();
        for (Shape shape : someShape) {
            shape.print();
        }
        defineShape(someShape);

    }

    /**
     * Method for generation array shapes from 10 elements
     */
    public static Shape[] generateShapes() {

        Random random = new Random();
        List<Integer> integers = new ArrayList<>();
        Shape[] shapes = new Shape[10];

        for (int i = 0; i < 10; i++) {
            integers.add(random.nextInt(2));
        }

        for (int i = 0; i < 10; i++) {
            if (integers.get(i) == 1) {
                shapes[i] = new Circle(new double[] {1, 1}, 2);
            } else {
                shapes[i] = new Triangle(new double[] {1, 1}, new double[] {3, 3}, new double[] {5, 1});
            }
        }
        return shapes;
    }

    /**
     * Method for determine which figure
     * @param shapes is array figure
     */
    public static void defineShape(Shape[] shapes) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i].getClass().getSimpleName().equals("Circle")) {
                integers.add(1);
            } else {
                integers.add(2);
            }
        }
        for (int i = 0; i < 10; i++) {
            if (integers.get(i) == 1) {
                System.out.println(i + " - Circle");
            } else {
                System.out.println(i + " - Triangle");
            }
        }
    }

}
