
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * I33
 *
 * @author 10 pro 64bit
 */
public class Main {

    public static void main(String[] args) {
        Display display = new Display();
        GetInput getInput = new GetInput();
        ManageEastAsiaCountries manager = new ManageEastAsiaCountries();
        ArrayList<EastAsiaCountries> countryList = new ArrayList<>();
        do {
            // Display main menu
            display.displayMenu();
            // Prompt user to select an option
            int choice = getInput.getChoice(1, 5);
            // Perform fuction based on user selection
            switch (choice) {
                // Input information of 11 countries in East Asia
                case 1:
                    manager.addCountryInformation(countryList);
                    break;
                // Display information of country has been inputted
                case 2:
                    manager.getRecentlyEnteredInformation(countryList);
                    break;
                // Search information of countries by name
                case 3:
                    manager.searchInformationByName(countryList);
                    break;
                // Display the information of countries ascending by name
                case 4:
                    manager.sortInformationByAscendingOrder(countryList);
                    break;
                // Exit program
                case 5:
                    System.exit(0);
            }
        } while (true);
    }
}
