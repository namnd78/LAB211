
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

    Scanner sc = new Scanner(System.in);

    int inputInteger(String message, int min, int max) {
        String input;
        int intNumber;
        do {
            System.out.print(message);
            input = sc.nextLine();
            // Check input must not be empty
            if (input.isEmpty()) {
                System.out.println("Input must not be empty. Please try again!");
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
                    System.out.println("Input must be intger. Please try again!");
                }
            }
        } while (true);
        return intNumber;
    }

    String inputString(String message, String format) {
        String input;
        do {
            System.out.print(message);
            input = sc.nextLine();
            // Check input must not be empty
            if (input.isEmpty()) {
                System.out.println("Input must not be empty. Please try again!");
                continue;
            } else {
                // Check required format
                if (format.isEmpty()) {
                    break;
                } else if (input.matches(format)) {
                    break;
                } else {
                    System.out.println("Input must matches format. Please try again!");
                    continue;
                }
            }
        } while (true);
        return input;
    }

    String inputCourse() {
        System.out.println("Course list:");
        System.out.println("\t1. Java");
        System.out.println("\t2. .Net");
        System.out.println("\t3. C/C++");
        String course = null;
        int choice = inputInteger("Enter student's course: ", 1, 3);
        switch (choice) {
            case 1:
                course = "Java";
                break;
            case 2:
                course = ".Net";
                break;
            case 3:
                course = "C/C++";
                break;
        }
        return course;
    }
}
