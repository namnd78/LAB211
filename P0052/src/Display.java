
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 10 pro 64bit
 */
class Display {

    void displayMenu() {
        System.out.printf("\n%32s%s\n", "", "MENU");
        System.out.println("==========================================================================");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending order");
        System.out.println("5. Exit");
        System.out.println("==========================================================================");
    }

    void displayCountryList(ArrayList<EastAsiaCountries> listByCountryName) {
        System.out.printf("%-15s%-18s%-20s%-15s\n", "ID", "Name", "Total Area", "Terrain");
        // Loop to access from the first to the last country in list
        for (EastAsiaCountries country : listByCountryName) {
            country.display();
        }
    }
}
