/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductManagement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author 10 pro 64bit
 */
class Display {

    void displayMainMenu() {
        System.out.println("\n========= PRODUCT MANAGEMENT SYSTEM =========");
        System.out.println("Main menu:");
        System.out.println("\t1. Add storekeeper");
        System.out.println("\t2. Add product");
        System.out.println("\t3. Update product");
        System.out.println("\t4. Search product");
        System.out.println("\t5. Sort product");
        System.out.println("\t6. Exit");
    }

    void displayStorekeeperList(ArrayList<Storekeeper> storekeeperList) {
        if (storekeeperList.isEmpty()) {
            System.out.println("Storekeeper list is empty!");
        } else {
            System.out.println("Storekeeper list: ");
            System.out.printf("\n| %-3s|%8s%-12s|\n", "ID", "", "Name");
            printLine("=", 27);
            // Loop to access from the first to the last storekeeper in list
            for (Storekeeper storekeeper : storekeeperList) {
                displayStorekeeper(storekeeper);
            }
        }
        System.out.println("");
    }

    private void displayStorekeeper(Storekeeper storekeeper) {
        System.out.printf("  %-5d%-20s\n", storekeeper.getStorekeeperId(), storekeeper.getStorekeeperName());
    }

    void displayUpdateMenu() {
        System.out.println("Update option: ");
        System.out.println("\t1.  Update product's ID");
        System.out.println("\t2.  Update product's name");
        System.out.println("\t3.  Update product's location");
        System.out.println("\t4.  Update product's category");
        System.out.println("\t5.  Update product's price");
        System.out.println("\t6.  Update product's manufacturing date");
        System.out.println("\t7.  Update product's expiry date");
        System.out.println("\t8.  Update product's storekeeper");
        System.out.println("\t9.  Update product's receipt date");
        System.out.println("\t10. Finish");
    }

    void displaySearchMenu() {
        System.out.println("Search option: ");
        System.out.println("\t1. Search by product's name");
        System.out.println("\t2. Search by product's category");
        System.out.println("\t3. Search by product's storekeeper");
        System.out.println("\t4. Search by product's receipt date");
    }

    void displayProductList(ArrayList<Product> productList) {
        if (productList.isEmpty()) {
            System.out.println("Product list is empty!");
        } else {
            System.out.println("Product list: ");
            System.out.printf("\n| %-3s|%-6s%-10s|%3s%-11s|%3s%-11s|%4s%-9s|%5s%-7s|%5s%-7s|%5s%-16s| %-13s|\n",
                    "ID", "", "Name", "", "Location", "", "Category", "", "Price", "", "MFG", "", "EXP", "", "Storekeeper", "Receipt Date");
            printLine("=", 128);
            // Loop to access from the first to the last product in list
            for (Product product : productList) {
                displayProduct(product);
            }
        }
        System.out.println("");
    }

    private void displayProduct(Product product) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String mfg = dateFormat.format(product.getManufacturingDate());
        String exp = dateFormat.format(product.getExpiryDate());
        String receiptDate = dateFormat.format(product.getReceiptDate());
        System.out.printf("  %-5d%-17s%-15s%-15s%-14d%-13s%-13s%-23s%-15s\n",
                product.getProductId(), product.getProductName(), product.getLocation(), product.getCategory(),
                product.getPrice(), mfg, exp, "[" + product.getStorekeeper().getStorekeeperId() + "]" + " "
                + product.getStorekeeper().getStorekeeperName(), receiptDate);
    }

    private void printLine(String character, int n) {
        // loop to print a character n times, to draw line
        for (int i = 0; i < n; i++) {
            System.out.print(character);
        }
        System.out.println("");
    }

}
