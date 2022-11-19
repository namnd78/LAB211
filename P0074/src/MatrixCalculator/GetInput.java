package MatrixCalculator;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 10 pro 64bit
 */
class GetInput {

    int inputInteger(String message1, String message2, int min, int max) {
        Scanner sc = new Scanner(System.in);
        String input;
        int intNumber;
        do {
            System.out.print(message1);
            input = sc.nextLine();
            // Check input must not be empty
            if (input.isEmpty()) {
                System.out.println("Input must not be empty");
                continue;
            } else {
                try {
                    intNumber = Integer.parseInt(input);
                    // Check input must be in given range
                    if (intNumber >= min && intNumber <= max) {
                        break;
                    } else {
                        System.out.println("Input must be in range " + min + " to " + max);
                        continue;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println(message2);
                }

            }
        } while (true);
        return intNumber;
    }

    int[][] inputMatrix1() {
        int row1 = inputInteger("Enter Row Matrix 1:", "Row must be integer", 1, Integer.MAX_VALUE);
        int column1 = inputInteger("Enter Column Matrix 1:", "Column must be integer", 1, Integer.MAX_VALUE);
        int[][] matrix1 = new int[row1][column1];
        // Loop to access from the first to the last row of matrix
        for (int i = 0; i < row1; i++) {
            // Loop to access from the first to the last column element of the row
            for (int j = 0; j < column1; j++) {
                matrix1[i][j] = inputInteger("Enter Matrix1[" + (i + 1) + "][" + (j + 1) + "]:",
                        "Value of matrix is digit", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        return matrix1;
    }

    int[][] inputMatrix2(int[][] matrix1, int choice) {
        int row1 = matrix1.length;
        int column1 = matrix1[0].length;
        int row2;
        int column2;
        // Check if user choice is multiply matrixes
        if (choice == 3) {
            do {
                row2 = inputInteger("Enter Row Matrix 2:", "Row must be integer", 1, Integer.MAX_VALUE);
                // Compare number of columns in matrix 1 with number of rows in matrix 2
                if (column1 == row2) {
                    break;
                } else {
                    System.out.println("Row Matrix 2 must be equal to Column Matrix 1");
                    continue;
                }
            } while (true);
            column2 = inputInteger("Enter Column Matrix 2:", "Column must be integer", 1, Integer.MAX_VALUE);
        } else {
            do {
                row2 = inputInteger("Enter Row Matrix 2:", "Row must be integer", 1, Integer.MAX_VALUE);
                // Compare number of rows in matrix 1 with number of rows in matrix 2
                if (row1 == row2) {
                    break;
                } else {
                    System.out.println("Row Matrix 2 must be equal to Row Matrix 1");
                    continue;
                }
            } while (true);
            do {
                column2 = inputInteger("Enter Column Matrix 2:", "Column must be integer", 1, Integer.MAX_VALUE);
                // Compare number of columns in matrix 1 with number of columns in matrix 2
                if (column1 == column2) {
                    break;
                } else {
                    System.out.println("Column Matrix 2 must be equal to Column Matrix 1");
                    continue;
                }
            } while (true);
        }
        int[][] matrix2 = new int[row2][column2];
        // Loop to access from the first to the last row of matrix
        for (int i = 0; i < row2; i++) {
            // Loop to access from the first to the last column element of the row
            for (int j = 0; j < column2; j++) {
                matrix2[i][j] = inputInteger("Enter Matrix2[" + (i + 1) + "][" + (j + 1) + "]:",
                        "Value of matrix is digit", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        return matrix2;
    }
}
