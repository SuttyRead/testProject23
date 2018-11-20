package com.ua.sutty.lab1.task_2;

/**
 * Circle class with methods(print, move, scaling)
 * @autor Roman Yaremenko
 * @version 0.1
 */
public class Circle extends Shape {

    /**
     *Field @point is point of a circle
     */
    private double[] point;
    /**
     * Field @radius is radius circle
     */
    private double radius;

    /**
     * Constructor without param
     */
    public Circle() {
    }

    /**
     * Constructor with param(@point, @radius)
     */
    public Circle(double[] point, double radius) {
        this.point = point;
        this.radius = radius;
    }

    /**
     * Method print for console output
     */
    public void print() {
        System.out.println("Circle: ");
        System.out.println("Point = " + "(" + point[0] + ";" + point[1] + ")");
        System.out.println("Radius = " + radius + "\n");
    }

    /**
     *Method move for dispacement circle in space
     */
    public void move(int[] point) {
        this.point[0] += point[0];
        this.point[1] += point[1];
    }

    /**
     * Method scaling for scale changes
     */
    public void scaling(double scale) {
        radius *= scale;
    }
}
