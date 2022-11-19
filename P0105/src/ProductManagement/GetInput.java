/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductManagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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

    Date inputDate(String message) {
        String input;
        Date date;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        do {
            System.out.print(message);
            input = sc.nextLine();
            // Check input must not be empty
            if (input.isEmpty()) {
                System.out.println("Input must not be empty. Please try again!");
                continue;
                // Check input format
                // \d{1,2}: match 1 or 2 digits number
                // \d{4}: match 4 digits number
                // /: match character '/'
            } else if (!input.matches("^\\d{1,2}/\\d{1,2}/\\d{4}$")) {
                System.out.println("Input must match format. Please try again!");
                continue;
            } else {
                try {
                    date = dateFormat.parse(input);
                    break;
                } catch (ParseException ex) {
                    System.out.println("Date does not exits. Please try again!");
                }
            }
        } while (true);
        return date;
    }

}
