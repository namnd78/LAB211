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
class Display {

    void displayMenu() {
        System.out.println("======Calculator program======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    void displayTitle(int choice) {
        switch (choice) {
            case 1:
                System.out.println("-------- Addition --------");
                break;
            case 2:
                System.out.println("-------- Subtraction --------");
                break;
            case 3:
                System.out.println("-------- Multiplication --------");
                break;
        }
    }

    private void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        // Loop to access from the first to the last row of matrix
        for (int i = 0; i < row; i++) {
            // Loop to access from the first to the last column element of the row
            for (int j = 0; j < column; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }

    void displayResult(int[][] matrix1, int[][] matrix2, int[][] resultMatrix, int choice) {
        System.out.println("-------- Result --------");
        displayMatrix(matrix1);
        switch (choice) {
            case 1:
                System.out.println("+");
                break;
            case 2:
                System.out.println("-");
                break;
            case 3:
                System.out.println("*");
                break;
        }
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(resultMatrix);
    }

}
