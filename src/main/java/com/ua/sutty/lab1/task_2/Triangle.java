package com.ua.sutty.lab1.task_2;

/**
 * Triangle class with methods(print, move, scaling)
 *
 * @version 0.1
 * @autor Roman Yaremenko
 */
public class Triangle extends Shape {

    /**
     * Field @a is point a of triangle
     */
    private double[] a;

    /**
     * Field @b is point b of triangle
     */
    private double[] b;

    /**
     * Field @c is point c of triangle
     */
    private double[] c;

    /**
     * Constructor without param
     */
    public Triangle() {
    }

    /**
     * Constructor with param(@a, @b, @c)
     */
    public Triangle(double[] a, double[] b, double[] c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Method print for console output
     */
    public void print() {
        System.out.println("Triangle: ");
        System.out.println("Point a = " + "(" + a[0] + ";" + a[1] + ")"
            + "(" + b[0] + ";" + b[1] + ")" + "(" + c[0] + ";" + c[1] + ")\n");
    }

    /**
     *Method move for dispacement triangle in space
     */
    public void move(int[] point) {
        a[0] += point[0];
        a[1] += point[1];
        b[0] += point[0];
        b[1] += point[1];
        c[0] += point[0];
        c[1] += point[1];
    }

    /**
     * Method scaling for scale changes
     */
    public void scaling(double scale) {
        a[0] *= scale;
        a[1] *= scale;
        b[0] *= scale;
        b[1] *= scale;
        c[0] *= scale;
        c[1] *= scale;
    }
}
