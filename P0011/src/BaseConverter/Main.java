/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseConverter;

/**
 * H33
 *
 * @author 10 pro 64bit
 */
public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        GetInput getInput = new GetInput();
        BaseConverter baseConverter = new BaseConverter();
        // Loop to repeat program until user want to exit
        do {
            // Display base systems menu
            manager.displayMenu();
            // Require user choose input base system
            int inputBase = getInput.getBase("Enter input base: ", 1, 3, -1);
            // Require user choose output base system
            int outputBase = getInput.getBase("Enter output base: ", 1, 3, inputBase);
            // Require user enter input value
            String inputValue = getInput.getInputValue(inputBase);
            // Perform convert process
            String outputValue = baseConverter.convertBase(inputValue, inputBase, outputBase);
            // Print output value
            manager.displayResult(outputValue);
            // Ask user confirm program repetition
            manager.confirmRepeat();
        } while (true);
    }
}
