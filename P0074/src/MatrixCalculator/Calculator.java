package MatrixCalculator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 10 pro 64bit
 */
class Calculator {

    int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int column = matrix1[0].length;
        int[][] resultMatrix = new int[row][column];
        // Loop to access from the first to the last row of each matrix
        for (int i = 0; i < row; i++) {
            // Loop to access from the first to the last column element of the row
            for (int j = 0; j < column; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return resultMatrix;
    }

    int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int column = matrix1[0].length;
        int[][] resultMatrix = new int[row][column];
        // Loop to access from the first to the last row of each matrix
        for (int i = 0; i < row; i++) {
            // Loop to access from the first to the last column element of the row
            for (int j = 0; j < column; j++) {
                resultMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return resultMatrix;
    }

    int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int column = matrix2[0].length;
        int column1 = matrix1[0].length;
        int[][] resultMatrix = new int[row][column];
        // Loop to access from the first to the last row of result matrix
        for (int i = 0; i < row; i++) {
            /* Loop to access from the first to the last column element of the row in 
            result matrix*/
            for (int j = 0; j < column; j++) {
                /* Loop to access from the first to the last element of each row in matrix 1,
                and access from the first to the last element of each column in matrix2*/
                for (int k = 0; k < column1; k++) {
                    resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return resultMatrix;
    }
}
