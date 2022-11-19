package LoginSystem;

import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * O33
 *
 * @author 10 pro 64bit
 */
public class Main {

    public static void main(String[] args) {
        Ebank ebank = new Ebank();
        GetInput getInput = new GetInput();
        LoginSystem loginSystem = new LoginSystem();
        do {
            // Display a menu
            loginSystem.displayMenu();
            // Ask user to select an option
            int choice = getInput.getChoice(1, 3);
            // Perform function based on user selection
            switch (choice) {
                case 1:
                    // Login with Vietnamese
                    ebank.setLocate(new Locale("vi"));
                    loginSystem.login(ebank);
                    break;
                case 2:
                    // Login with English
                    ebank.setLocate(new Locale("en"));
                    loginSystem.login(ebank);
                    break;
                case 3:
                    // Exit program
                    System.exit(0);
                    break;

            }
        } while (true);
    }

}
