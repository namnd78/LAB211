
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 10 pro 64bit
 */
public class ManageEastAsiaCountries {

    Display display = new Display();
    GetInput getInput = new GetInput();

    void addCountryInformation(ArrayList<EastAsiaCountries> countryList) {
        // Loop until 11 countries inputted
        do {
            // Check list has enough 11 countries
            if (countryList.size() == 11) {
                System.out.println("List of 11 countries in East Asia is full!");
                break;
            }
            System.out.printf("%30s%s\n", "", "Add Country");
            System.out.println("--------------------------------------------------------------------------");
            String code;
            // loop until code not duplicate
            do {
                // ^: match the beginning of the string
                // [a-zA-Z]+: match letter from a to z (lower/upper case), one or more times
                // $: match the end of the string
                code = getInput.getString("Enter code of country:", "^[a-zA-Z]+$").toUpperCase();
                // Check entered code exist in the list
                if (checkDuplicateCode(code, countryList)) {
                    System.out.println("Country code already exist. Please try again!");
                    continue;
                } else {
                    break;
                }
            } while (true);
            String name;
            do {
                // ^: match the beginning of the string
                // [A-Z][a-z]*: each word in name has the first letter in uppercase (A to Z), others in lowercase (a to z)
                // *: stand behind string that occur zero or more times
                // $: match the end of the string
                name = getInput.getString("Enter name of country:", "^[A-Z][a-z]*( [A-Z][a-z]*)*$");
                // Check 2 countries must not have same name
                if (checkDuplicateName(name, countryList)) {
                    System.out.println("Duplicate country name. Please try again!");
                } else {
                    break;
                }
            } while (true);
            float area = getInput.getArea();
            String terrain = getInput.getString("Enter terrain of country:", "");
            countryList.add(new EastAsiaCountries(code, name, area, terrain));
            System.out.println("Country added successfully!");
        } while (true);
    }

    void getRecentlyEnteredInformation(ArrayList< EastAsiaCountries> countryList) {
        // Check empty list
        if (countryList.isEmpty()) {
            System.out.println("List is empty. Please add country first!");
            return;
        }
        System.out.printf("%25s%s\n", "", "Last inputted country");
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-15s%-18s%-20s%-15s\n", "ID", "Name", "Total Area", "Terrain");
        countryList.get(countryList.size() - 1).display();
    }

    void searchInformationByName(ArrayList<EastAsiaCountries> countryList) {
        // Check empty list
        if (countryList.isEmpty()) {
            System.out.println("List is empty. Please add country first!");
            return;
        }
        System.out.printf("%24s%s\n", "", "Search Country By Name");
        System.out.println("--------------------------------------------------------------------------");
        ArrayList<EastAsiaCountries> listByCountryName = new ArrayList<>();
        String name = getInput.getString("Enter the name you want to search for:", "");
        // Loop to access from the first to the last country in the list
        for (EastAsiaCountries country : countryList) {
            // Check country's name in list contain user enterred name
            if (country.getCountryName().toLowerCase().contains(name.toLowerCase())) {
                listByCountryName.add(country);
            }
        }
        // Check if no country found
        if (listByCountryName.isEmpty()) {
            System.out.println("No country found!");
        } else {
            display.displayCountryList(listByCountryName);
        }
    }

    void sortInformationByAscendingOrder(ArrayList<EastAsiaCountries> countryList) {
        // Check empty list
        if (countryList.isEmpty()) {
            System.out.println("List is empty. Please add country first!");
            return;
        }
        System.out.printf("%25s%s\n", "", "Sort Country By Name");
        System.out.println("--------------------------------------------------------------------------");
        Collections.sort(countryList, new Comparator<EastAsiaCountries>() {
            @Override
            public int compare(EastAsiaCountries c1, EastAsiaCountries c2) {
                return c1.getCountryName().compareToIgnoreCase(c2.getCountryName());
            }
        });
        display.displayCountryList(countryList);
    }

    private boolean checkDuplicateCode(String code, ArrayList<EastAsiaCountries> countryList) {
        // Loop to access from the first to the last country in the list
        for (EastAsiaCountries country : countryList) {
            // compare user entered code with code of country in the list
            if (code.equals(country.getCountryCode())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDuplicateName(String name, ArrayList<EastAsiaCountries> countryList) {
        // Loop to access from the first to the last country in the list
        for (EastAsiaCountries country : countryList) {
            // compare user entered name with other country's name in list
            if (name.equalsIgnoreCase(country.getCountryName())) {
                return true;
            }
        }
        return false;
    }

}
