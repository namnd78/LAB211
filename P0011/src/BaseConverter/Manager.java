package BaseConverter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 10 pro 64bit
 */
class Manager {

    void displayMenu() {
        System.out.println("\n========= BASE NUMBER SYSTEM CONVERTER =========");
        System.out.println("Base number systems menu:");
        System.out.println("\t1. Binary");
        System.out.println("\t2. Decimal");
        System.out.println("\t3. Hexadecimal");
    }

    void displayResult(String outputValue) {
        System.out.println("Convert result: " + outputValue);
    }

    void confirmRepeat() {
        GetInput getInput = new GetInput();
        // [yYnN]: match one of characters y, Y, n, N
        String confirm = getInput.getString("Do you want to continue [Y/N]?: ", "[yYnN]");
        // Compare user input with y
        if (confirm.equalsIgnoreCase("y")) {
            return;
        } else {
            System.exit(0);
        }
    }

}
