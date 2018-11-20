package com.ua.sutty.lab1.task_1;

/**
 * Matrix class with methods(add, multiplication, transportation)
 * and two-dimensional array
 *
 * @version 0.1
 * @autor Roman Yaremenko
 */
public class Matrix {

    /**
     * Field size matrix
     */
    public static final int sizeMatrix = 3;
    /**
     * Field @valueMatrix is value matrix
     */
    private double[][] valueMatrix;

    /**
     * Constructor without param
     */
    public Matrix() {
    }

    /**
     * Constructor with @param valueMatrix
     */
    public Matrix(double[][] valueMatrix) {
        this.valueMatrix = valueMatrix;
    }

    /**
     * Setter
     */
    public void setValueMatrix(double[][] valueMatrix) {
        this.valueMatrix = valueMatrix;
    }

    /**
     * Getter
     * @return valueMatrix
     */
    public double[][] getValueMatrix() {
        return valueMatrix;
    }

    /**
     * Method addition two matrix 3x3
     *
     * @param someMatrix is matrix 3x3
     * @return new matrix which is sum from firstMatrix and secondMatrix
     */
    public Matrix addMatrix(Matrix someMatrix) {

        double[][] newValueMatrix = new double[3][3];

        for (int i = 0; i < sizeMatrix; i++) {
            for (int j = 0; j < sizeMatrix; j++) {
                newValueMatrix[i][j] = this.getValueMatrix()[i][j] + someMatrix.getValueMatrix()[i][j];
            }
        }
        return new Matrix(newValueMatrix);
    }

    /**
     * Method multiplication two matrix
     *
     * @param someMatrix  is matrix 3x3
     * @return new matrix which is multiplication from firstMatrix and secondMatrix
     */
    public  Matrix multiplyMatrix(Matrix someMatrix) {

        int firstMatrixColumnLength = this.getValueMatrix()[0].length;
        int secondMatrixRowLength = someMatrix.getValueMatrix().length;
        if (firstMatrixColumnLength != secondMatrixRowLength) {
            return null;
        }
        int firstMatrixRowLength = this.getValueMatrix().length;
        int secondMatrixColumnLength = someMatrix.valueMatrix[0].length;

        double[][] newMatrix = new double[firstMatrixRowLength][secondMatrixColumnLength];

        for (int i = 0; i < firstMatrixRowLength; i++) {
            for (int j = 0; j < secondMatrixColumnLength; j++) {
                newMatrix[i][j] = 0;
                for (int k = 0; k < firstMatrixColumnLength; k++) {
                    newMatrix[i][j] += this.getValueMatrix()[i][k] * someMatrix.getValueMatrix()[k][j];
                }
            }
        }

        return new Matrix(newMatrix);
    }

    /**
     * Method transport matrix
     *
     * @return Matrix that was transportation
     */
    public Matrix transportationMatrix() {
        double[][] newMatrix = new double[sizeMatrix][sizeMatrix];
        for (int i = 0; i < sizeMatrix; i++) {
            for (int j = 0; j < sizeMatrix; j++) {
                newMatrix[i][j] = this.getValueMatrix()[j][i];
            }
        }
        return new Matrix(newMatrix);
    }

    /**
     * Method print matrix
     */
    public void printMatrix() {
        for (int i = 0; i < sizeMatrix; i++) {
            for (int j = 0; j < sizeMatrix; j++) {
                System.out.print(this.valueMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
