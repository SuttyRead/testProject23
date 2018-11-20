package com.ua.sutty.lab1.task_2;

/**
 * Main class with operations over Shape(move, scaling)
 * @autor Roman Yaremenko
 * @version 0.1
 */
public class Main {


    /**
     * Main method for call other methods
     */
    public static void main(String[] args) {

        Circle circle = new Circle(new double[] {1, 1}, 2);
        Triangle triangle = new Triangle(new double[] {1, 1}, new double[] {3, 3}, new double[] {5, 1});

        System.out.println("Print shapes");
        System.out.println("----------------------------------------------");
        System.out.println("Print circle");
        circle.print();
        System.out.println("----------------------------------------------");
        System.out.println("Print triangle");
        triangle.print();
        System.out.println("----------------------------------------------");

        System.out.println("Move with circle");
        System.out.println("We moved right 2 and we moved up 1");
        circle.move(new int[] {2, 1});
        System.out.println("We zoomed in 2 times");
        circle.scaling(2);
        circle.print();
        System.out.println("----------------------------------------------");

        System.out.println("Move with triangle");
        System.out.println("We moved right 2 and we moved up 2");
        triangle.move(new int[] {2, 2});
        System.out.println("We reduced in 0.5 times");
        triangle.scaling(0.5);
        triangle.print();

    }

}
