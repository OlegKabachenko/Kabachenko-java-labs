package edu.ntudp.pzks.lab3;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class Matrix {
    private final int MAX_SIZE = 20;
    private final int MIN_SIZE = 1;
    private final int MIN_RANDOM = 1;
    private final int MAX_RANDOM = 100;
    private final Scanner scanner = new Scanner(System.in);
    private int[][] matrix;

    public static void main(String[] args) {

        Matrix matrix = new Matrix();
        matrix.createMatrix();
        matrix.printMatrix();

        int max = matrix.getMaxValue();
        System.out.println("Maximum value of the matrix: " + max);

        int min = matrix.getMinValue();
        System.out.println("Minimum value of the matrix: " + min);

        double arithmeticMean = matrix.calculateArithmeticMean();
        System.out.println("Arithmetic mean of the matrix: " + arithmeticMean);

        double geometricMean = matrix.calculateGeometricMean();
        System.out.println("Geometric mean of the matrix: " + geometricMean);

    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getValidInt(String text, int minVal, int maxVal) {
        int size;

        while (true) {
            System.out.println(text);

            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                if (size >= minVal && size <= maxVal) {
                    return size;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid value, please try again.");
        }
    }

    public int[] getMatrixSizes() {
        int rows = getValidInt("Enter the number of rows of the matrix:", MIN_SIZE, MAX_SIZE);
        int cols = getValidInt("Enter the number of columns of the matrix:", MIN_SIZE, MAX_SIZE);
        return new int[]{rows, cols};
    }

    public void createMatrixRandomly() {
        int[] sizes = getMatrixSizes();
        int rows = sizes[0];
        int cols = sizes[1];

        int[][] matrix = new int[rows][cols];
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(MAX_RANDOM - MIN_RANDOM + 1) + MIN_RANDOM;
            }
        }
       setMatrix(matrix);
    }

    public void createMatrixManually() {
        int[] sizes = getMatrixSizes();
        int rows = sizes[0];
        int cols = sizes[1];
        int[][] matrix = new int[rows][cols];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                while (true) {
                    System.out.print("Element [" + i + "][" + j + "]: ");
                    if (scanner.hasNextInt()) {
                        matrix[i][j] = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("Invalid value, please try again.");
                        scanner.next();
                    }
                }
            }
        }
        this.matrix = matrix;
    }

    public void createMatrix() {
        System.out.println("Choose how to create the matrix:");
        System.out.println("1. Create the matrix randomly");
        System.out.println("2. Manually enter matrix elements");
        int usrInput = getValidInt("Enter your choice (1 or 2): ", 1, 2);

        if (usrInput ==1){
            createMatrixRandomly();
        }
        else{
            createMatrixManually();
        }
    }

    public void printMatrix() {
        if (matrix != null) {
            System.out.println("Matrix:");
            for (int[] row : matrix) {
                for (int num : row) {
                    System.out.printf("%5d", num);
                }
                System.out.println();
            }
        }
    }

    public int getMaxValue() {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int num : row) {
                if (num > max) max = num;
            }
        }
        return max;
    }

    public int getMinValue() {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int num : row) {
                if (num < min) min = num;
            }
        }
        return min;
    }

    public double calculateArithmeticMean() {
        int sum = 0;
        int elementsCount = Stream.of(matrix).mapToInt(m -> m.length).sum();
        for (int[] row : matrix) {
            for (int num : row) {
                sum += num;
            }
        }
        return (double) sum / elementsCount;
    }

    public double calculateGeometricMean() {
        double product = 1.0;
        int elementsCount = Stream.of(matrix).mapToInt(m -> m.length).sum();
        for (int[] row : matrix) {
            for (int num : row) {
                if (num < 0) {
                    System.out.println("Geometric mean cannot be calculated for negative numbers!");
                    return 0;
                }

                product *= num;
            }
        }
        return Math.pow(product, 1.0 / elementsCount);
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public int getMIN_SIZE() {
        return MIN_SIZE;
    }

    public int getMIN_RANDOM() {
        return MIN_RANDOM;
    }

    public int getMAX_RANDOM() {
        return MAX_RANDOM;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
