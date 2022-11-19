
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

    int getChoice(int min, int max) {
        String input;
        int choice;
        do {
            System.out.print("Please choose one option: ");
            input = sc.nextLine();
            // Check input must not be empty
            if (input.isEmpty()) {
                System.out.println("Input must not be empty. Please try again!");
                continue;
            } else {
                try {
                    choice = Integer.parseInt(input);
                    // Check input must be in given range
                    if (choice >= min && choice <= max) {
                        break;
                    } else {
                        System.out.println("Choice must be in range " + min + " to " + max);
                        continue;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Input must be intger. Please try again!");
                }
            }
        } while (true);
        return choice;
    }

    String getString(String message, String format) {
        String input;
        do {
            System.out.println(message);
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

    float getArea() {
        String input;
        float area;
        do {
            System.out.println("Enter total Area:");
            input = sc.nextLine();
            // Check input must no be empty
            if (input.isEmpty()) {
                System.out.println("Input must not be empty. Please try again!");
                continue;
            } else {
                try {
                    area = Float.parseFloat(input);
                    // Check area must be greater than 0
                    if (area <= 0) {
                        System.out.println("Area must be greater than 0. Please try again!");
                        continue;
                    } // Check area too large
                    else if (area > Float.MAX_VALUE) {
                        System.out.println("Invalid area. Please try again!");
                        continue;
                    } else {
                        break;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Input must be number. Please try again!");
                }
            }
        } while (true);
        return area;
    }
}
