package MatrixCalculator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Q33
 *
 * @author 10 pro 64bit
 */
public class Main {

    public static void main(String[] args) {
        Display display = new Display();
        GetInput getInput = new GetInput();
        Calculator calculator = new Calculator();
        int[][] matrix1;
        int[][] matrix2;
        int[][] resultMatrix;
        do {
            // 1. Display a menu
            display.displayMenu();
            // 2. Require user to select an option
            int choice = getInput.inputInteger("Your choice:", "Input must be integer", 1, 4);
            // 3. Perform user selected option
            switch (choice) {
                // Addition matrixes
                case 1:
                    display.displayTitle(choice);
                    // prompt user input maxtrix 1
                    matrix1 = getInput.inputMatrix1();
                    // prompt user input matrix 2
                    matrix2 = getInput.inputMatrix2(matrix1, choice);
                    // add matrix 1 & matrix 2
                    resultMatrix = calculator.additionMatrix(matrix1, matrix2);
                    // display result
                    display.displayResult(matrix1, matrix2, resultMatrix, choice);
                    break;
                // Subtraction matrixes
                case 2:
                    display.displayTitle(choice);
                    // prompt user input matrix 1
                    matrix1 = getInput.inputMatrix1();
                    // prompt user input matrix 2
                    matrix2 = getInput.inputMatrix2(matrix1, choice);
                    // subtract matrix 1 & matrix 2
                    resultMatrix = calculator.subtractionMatrix(matrix1, matrix2);
                    // display result
                    display.displayResult(matrix1, matrix2, resultMatrix, choice);
                    break;
                // Multiplication matrixes
                case 3:
                    display.displayTitle(choice);
                    // prompt user input maxtrix 1
                    matrix1 = getInput.inputMatrix1();
                    // prompt user input matrix 2
                    matrix2 = getInput.inputMatrix2(matrix1, choice);
                    // multiply matrix 1 & matrix 2
                    resultMatrix = calculator.multiplicationMatrix(matrix1, matrix2);
                    // display result
                    display.displayResult(matrix1, matrix2, resultMatrix, choice);
                    break;
                // Exit program
                case 4:
                    System.exit(0);
            }
        } while (true);
    }
}
