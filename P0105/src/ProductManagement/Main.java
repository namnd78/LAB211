/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductManagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * V33
 *
 * @author 10 pro 64bit
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        Display display = new Display();
        GetInput getInput = new GetInput();
        ArrayList<Storekeeper> storekeeperList = new ArrayList<>();
        ArrayList<Product> productList = new ArrayList<>();
        ProductManagement productManagement = new ProductManagement();
        //test
//        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//        storekeeperList.add(new Storekeeper(1, "Nguyen Van An"));
//        storekeeperList.add(new Storekeeper(2, "Tran Tuan Thinh"));
//        storekeeperList.add(new Storekeeper(3, "Do Viet Hoang"));
//        productList.add(new Product(15, "Hotdog", "Ha Noi", "Food", 30000, df.parse("2/1/2022"), df.parse("2/1/2034"), storekeeperList.get(1), df.parse("3/2/2022")));
//        productList.add(new Product(26, "Refrigerator", "Hai Phong", "Electric", 10000000, df.parse("10/12/2020"), df.parse("12/12/2028"), storekeeperList.get(0), df.parse("1/1/2021")));
//        productList.add(new Product(18, "Laptop", "Ho Chi Minh", "Electric", 20000000, df.parse("10/2/2020"), df.parse("1/12/2030"), storekeeperList.get(2), df.parse("1/10/2021")));
//        productList.add(new Product(34, "Table", "Da Nang", "Furniture", 2500000, df.parse("1/12/2019"), df.parse("1/12/2030"), storekeeperList.get(0), df.parse("20/7/2021")));
        do {
            // 1. Display a main menu
            display.displayMainMenu();
            // 2. Require user to select an option
            int choice = getInput.inputInteger("Please enter an option: ", 1, 6);
            // 3. Perform user selection
            switch (choice) {
                // Add storekeeper
                case 1:
                    productManagement.addStorekeeper(storekeeperList);
                    break;
                // Add product
                case 2:
                    productManagement.addProduct(storekeeperList, productList);
                    break;
                // Update product
                case 3:
                    productManagement.updateProduct(storekeeperList, productList);
                    break;
                // Search product by Name, Category, Storekeeper, ReceiptDate
                case 4:
                    productManagement.searchProduct(productList);
                    break;
                // Sort product by Dexpiry date, Date of manufacture 
                case 5:
                    productManagement.sortProduct(productList);
                    break;
                // Exit
                case 6:
                    System.exit(0);
            }
        } while (true);
    }
}
