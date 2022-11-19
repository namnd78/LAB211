package BaseConverter;


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

    int getBase(String message, int min, int max, int inputBase) {
        String input;
        int choice;
        int base = -1;
        do {
            System.out.print(message);
            input = sc.nextLine();
            // Check input must not be empty
            if (input.isEmpty()) {
                System.out.println("Input must not be empty. Please try again!");
                continue;
            } else {
                try {
                    choice = Integer.parseInt(input);
                    // Check choice must be in rage
                    if (choice >= min && choice <= max) {
                        switch (choice) {
                            case 1:
                                base = 2;
                                break;
                            case 2:
                                base = 10;
                                break;
                            case 3:
                                base = 16;
                                break;
                        }
                        // Check two bases must not the same
                        if (base == inputBase) {
                            System.out.println("Output base must not be the same as input base!");
                            continue;
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("Input must be in range " + min + " to " + max + ". Please try again!");
                        continue;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Input must be integer. Please try again!");
                }
            }
        } while (true);
        return base;
    }

    String getInputValue(int inputBase) {
        String format = "";
        switch (inputBase) {
            case 2:
                // ^: match the beginning of string
                // [01]+: match digit 0 or 1, one or more times
                // $: match the end of string
                format = "^[01]+$";
                break;
            case 10:
                // ^: match the beginning of string
                // [0-9]+: match digit from 0 to 9, one or more times
                // $: match the end of string
                format = "^[0-9]+$";
                break;
            case 16:
                // ^: match the beginning of string
                // [0-9a-fA-F]+: match digit from 0 to 9, letter from a to z(lower or uppercase), one or more times
                // $: match the end of string
                format = "^[0-9a-fA-F]+$";
                break;
        }
        String value = "";
        do {
            System.out.print("Enter value to convert: ");
            value = sc.nextLine();
            // Check input must not empty
            if (value.isEmpty()) {
                System.out.println("Input must not be empty. Please try again!");
                continue;
            } else {
                // Check value inputted must in format of base
                if (value.matches(format)) {
                    break;
                } else {
                    System.out.println("Input must match format of base " + inputBase + ". Please try again!");
                    continue;
                }
            }
        } while (true);
        return value.toUpperCase();
    }

    String getString(String message, String format) {
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

}
