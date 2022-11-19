package LoginSystem;

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
        System.out.println("");
        return choice;
    }
}
