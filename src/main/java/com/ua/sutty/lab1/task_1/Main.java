package com.ua.sutty.lab1.task_1;

import java.util.Random;


/**
 * Main class with operations over matrix(add, multiplication, transportation)
 *
 * @version 0.1
 * @autor Roman Yaremenko
 */
public class Main {

    /**
     * Main method for call other methods
     */
    public static void main(String[] args) {

        Matrix firstMatrix = new Matrix();
        Matrix secondMatrix = new Matrix();

        System.out.println("Generated matrix");
        System.out.println("First matrix\n");
        firstMatrix.setValueMatrix(generateValueMatrix());
        firstMatrix.printMatrix();

        System.out.println("Second matrix\n");
        secondMatrix.setValueMatrix(generateValueMatrix());
        secondMatrix.printMatrix();


        System.out.println("Add\n");
        Matrix afterAdd = firstMatrix.addMatrix(secondMatrix);
        afterAdd.printMatrix();

        System.out.println("Multiply\n");
        Matrix afterMultiplication= firstMatrix.multiplyMatrix(secondMatrix);
        afterMultiplication.printMatrix();

        System.out.println("Transport\n");
        Matrix afterTransportation = firstMatrix.transportationMatrix();
        afterTransportation.printMatrix();

    }

    /**
     * Method for generate value matrix 3x3
     * @return Matrix value that was generate
     */
    public static double[][] generateValueMatrix() {
        final int sizeMatrix = 3;
        double[][] newMatrix = new double[sizeMatrix][sizeMatrix];
        Random random = new Random();
        for (int i = 0; i < sizeMatrix; i++) {
            for (int j = 0; j < sizeMatrix; j++) {
                newMatrix[i][j] = random.nextDouble();
            }
        }
        return newMatrix;
    }
}
