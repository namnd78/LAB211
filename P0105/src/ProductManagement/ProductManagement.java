/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductManagement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author 10 pro 64bit
 */
class ProductManagement {

    GetInput getInput = new GetInput();
    Display display = new Display();

    void addStorekeeper(ArrayList<Storekeeper> storekeeperList) {
        display.displayStorekeeperList(storekeeperList);
        int keeperId = storekeeperList.size() + 1;
        System.out.println("--------- Add Storekeeper ---------");
        // ^: match the beginning of the string
        // [A-Z][a-z]*: each word in name has the first letter in uppercase (A to Z), others in lowercase (a to z)
        // *: stand behind string that occur zero or more times
        // $: match the end of the string
        String keeperName = getInput.inputString("Enter storekeeper's name: ", "^[A-Z][a-z]*( [A-Z][a-z]*)*$");
        storekeeperList.add(new Storekeeper(keeperId, keeperName));
        System.out.println("Storekeeper added successfully!");
        display.displayStorekeeperList(storekeeperList);
    }

    void addProduct(ArrayList<Storekeeper> storekeeperList, ArrayList<Product> productList) {
        // Check product must have Storekeeper to manage
        if (storekeeperList.isEmpty()) {
            System.out.println("There is no storekeeper available to manage products. Please add storekeeper first!");
            return;
        }
        display.displayProductList(productList);
        System.out.println("--------- Add Product ---------");
        int productId;
        do {
            productId = getInput.inputInteger("Enter product's ID: ", 0, Integer.MAX_VALUE);
            // Check user's entered ID duplicate product's ID in the list 
            if (checkDuplicateProductId(-1, productId, productList)) {
                System.out.println("This ID already exists. Please try again!");
                continue;
            } else {
                break;
            }
        } while (true);
        String productName = getInput.inputString("Enter product's name: ", "");
        String location = getInput.inputString("Enter product's location: ", "");
        String category = getInput.inputString("Enter product's category: ", "");
        int price = getInput.inputInteger("Enter product's price: ", 0, Integer.MAX_VALUE);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date manufacturingDate;
        do {
            manufacturingDate = getInput.inputDate("Enter product's manufacturing date [dd/MM/yyyy]: ");
            Date today = new Date();
            // Check manufacturing date must before today
            if (manufacturingDate.before(today)) {
                break;
            } else {
                System.out.println("Manufacturing date must before today (" + dateFormat.format(today)
                        + "). Please try again!");
                continue;
            }
        } while (true);
        Date expiryDate;
        do {
            expiryDate = getInput.inputDate("Enter product's expiry date [dd/MM/yyyy]: ");
            // Check expiry date must after manufacturing date
            if (expiryDate.after(manufacturingDate)) {
                break;
            } else {
                System.out.println("Expiry date must after manufacturing date (" + dateFormat.format(manufacturingDate)
                        + "). Please try again!");
                continue;
            }
        } while (true);
        Storekeeper storekeeper = null;
        do {
            display.displayStorekeeperList(storekeeperList);
            int keeperID = getInput.inputInteger("Enter storekeeper's ID: ", 1, storekeeperList.size());
            // Loop to access from the first to the last newStorekeeper of the list
            for (Storekeeper keeperInList : storekeeperList) {
                // Compare user's entered id with id of newStorekeeper in list
                if (keeperID == keeperInList.getStorekeeperId()) {
                    storekeeper = keeperInList;
                    break;
                }
            }
        } while (storekeeper == null);
        Date receiptDate;
        do {
            receiptDate = getInput.inputDate("Enter product's receipt date [dd/MM/yyyy]: ");
            // Check receipt date must after manu date and before exp date
            if (receiptDate.after(manufacturingDate) && receiptDate.before(expiryDate)) {
                break;
            } else {
                System.out.println("Receipt date must be from " + dateFormat.format(manufacturingDate) + " to "
                        + dateFormat.format(expiryDate) + ". Please try again!");
                continue;
            }
        } while (true);
        Product product = new Product(productId, productName, location, category, price, manufacturingDate, expiryDate, storekeeper, receiptDate);
        productList.add(product);
        System.out.println("Product added successfully!");
        display.displayProductList(productList);
    }

    void updateProduct(ArrayList<Storekeeper> storekeeperList, ArrayList<Product> productList) {
        // Check empty list
        if (productList.isEmpty()) {
            System.out.println("Product list is empty!");
            return;
        } else {
            display.displayProductList(productList);
        }
        System.out.println("--------- Update Product ---------");
        int productId;
        Product searchedProduct;
        int choice;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        do {
            productId = getInput.inputInteger("Enter product's ID: ", 0, Integer.MAX_VALUE);
            searchedProduct = searchProductById(productId, productList);
            if (searchedProduct == null) {
                System.out.println("ID does not exist. Please try again!");
                continue;
            } else {
                break;
            }
        } while (true);
        do {
            display.displayUpdateMenu();
            choice = getInput.inputInteger("Please select an option: ", 1, 10);
            switch (choice) {
                case 1:
                    int newProductId;
                    do {
                        newProductId = getInput.inputInteger("Enter product's ID: ", 0, Integer.MAX_VALUE);
                        // Check user's entered ID duplicate product's ID in the list 
                        if (checkDuplicateProductId(productId, newProductId, productList)) {
                            System.out.println("Duplicate product ID. Please try again!");
                            continue;
                        } else {
                            break;
                        }
                    } while (true);
                    searchedProduct.setProductId(newProductId);
                    break;
                case 2:
                    String newProductName = getInput.inputString("Enter product's name: ", "");
                    searchedProduct.setProductName(newProductName);
                    break;
                case 3:
                    String newLocation = getInput.inputString("Enter product's location: ", "");
                    searchedProduct.setLocation(newLocation);
                    break;
                case 4:
                    String newCategory = getInput.inputString("Enter product's category: ", "");
                    searchedProduct.setCategory(newCategory);
                    break;
                case 5:
                    int newPrice = getInput.inputInteger("Enter product's price: ", 0, Integer.MAX_VALUE);
                    searchedProduct.setPrice(newPrice);
                    break;
                case 6:
                    Date newManufacturingDate;
                    do {
                        newManufacturingDate = getInput.inputDate("Enter product's manufacturing date [dd/MM/yyyy]: ");
                        Date today = new Date();
                        // Check manufacturing date must before today
                        if (newManufacturingDate.before(today)) {
                            break;
                        } else {
                            System.out.println("Manufacturing date must before today (" + dateFormat.format(today)
                                    + "). Please try again!");
                            continue;
                        }
                    } while (true);
                    searchedProduct.setManufacturingDate(newManufacturingDate);
                    break;
                case 7:
                    Date newExpiryDate;
                    do {
                        newExpiryDate = getInput.inputDate("Enter product's expiry date [dd/MM/yyyy]: ");
                        Date manufacturingDate = searchedProduct.getManufacturingDate();
                        // Check expiry date must after manufacturing date
                        if (newExpiryDate.after(manufacturingDate)) {
                            break;
                        } else {
                            System.out.println("Expiry date must after manufacturing date ("
                                    + manufacturingDate + "). Please try again!");
                            continue;
                        }
                    } while (true);
                    searchedProduct.setExpiryDate(newExpiryDate);
                    break;
                case 8:
                    Storekeeper newStorekeeper = null;
                    do {
                        display.displayStorekeeperList(storekeeperList);
                        int keeperID = getInput.inputInteger("Enter storekeeper's ID of: ", 1, storekeeperList.size());
                        // Loop to access from the first to the last Storekeeper of the list
                        for (Storekeeper keeperInList : storekeeperList) {
                            // Compare user's entered id with id of Storekeeper in list
                            if (keeperID == keeperInList.getStorekeeperId()) {
                                newStorekeeper = keeperInList;
                                break;
                            }
                        }
                    } while (newStorekeeper == null);
                    searchedProduct.setStorekeeper(newStorekeeper);
                    break;
                case 9:
                    Date newReceiptDate;
                    do {
                        newReceiptDate = getInput.inputDate("Enter product's receipt date [dd/MM/yyyy]: ");
                        Date manufacturingDate = searchedProduct.getManufacturingDate();
                        Date expiryDate = searchedProduct.getExpiryDate();
                        // Check receipt date must after manu date and before exp date
                        if (newReceiptDate.after(manufacturingDate) && newReceiptDate.before(expiryDate)) {
                            break;
                        } else {
                            System.out.println("Receipt date must be from " + manufacturingDate + " to "
                                    + expiryDate + ". Please try again!");
                            continue;
                        }
                    } while (true);
                    searchedProduct.setReceiptDate(newReceiptDate);
                    break;
            }
        } while (choice <= 9);
        System.out.println("Product updated successfully!");
        display.displayProductList(productList);
    }

    void searchProduct(ArrayList<Product> productList) {
        // Check empty list
        if (productList.isEmpty()) {
            System.out.println("Product list is empty!");
            return;
        } else {
            display.displayProductList(productList);
        }
        System.out.println("--------- Search Product ---------");
        display.displaySearchMenu();
        int choice = getInput.inputInteger("Please select an option: ", 1, 4);
        switch (choice) {
            case 1:
                searchByName(productList);
                break;
            case 2:
                searchByCategory(productList);
                break;
            case 3:
                searchByStorekeeper(productList);
                break;
            case 4:
                searchByReceiptDate(productList);
                break;
        }
    }

    void sortProduct(ArrayList<Product> productList) {
        // Check empty list
        if (productList.isEmpty()) {
            System.out.println("Product list is empty!");
            return;
        } else {
            display.displayProductList(productList);
        }
        System.out.println("--------- Sort Product By Expiry Date ---------");
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                // Compare expiry date of two products in the list
                if (p1.getExpiryDate().equals(p2.getExpiryDate())) {
                    return p1.getManufacturingDate().compareTo(p2.getManufacturingDate());
                } else {
                    return p1.getExpiryDate().compareTo(p2.getExpiryDate());
                }
            }
        });
        System.out.println("Product list sorted successfully!");
        display.displayProductList(productList);
    }

    private boolean checkDuplicateProductId(int oldProductId, int newProductId, ArrayList<Product> productList) {
        // Compare old product id with new product id
        if (oldProductId == newProductId) {
            return false;
        }
        // Loop to access from the first to the last product of the list
        for (Product product : productList) {
            // Compare new id entered with id of product in the list
            if (product.getProductId() == newProductId) {
                return true;
            }
        }
        return false;
    }

    private Product searchProductById(int id, ArrayList<Product> productList) {
        Product searchedProduct = null;
        // Loop to access from the first to the last product of the list
        for (Product product : productList) {
            // Compare user's entered Id with Id of product in the list
            if (product.getProductId() == id) {
                searchedProduct = product;
                break;
            }
        }
        return searchedProduct;
    }

    private void searchByName(ArrayList<Product> productList) {
        System.out.println("-------- Search By Name --------");
        String productName = getInput.inputString("Enter product's name: ", "");
        ArrayList<Product> resultList = new ArrayList<>();
        // Loop to access from the first to the last product of the list
        for (Product product : productList) {
            // Compare user's entered name with name of product in the list, irrespective of the case
            if (product.getProductName().equalsIgnoreCase(productName)) {
                resultList.add(product);
            }
        }
        if (resultList.isEmpty()) {
            System.out.println("No product found!");
        } else {
            System.out.println("Search result: ");
            display.displayProductList(resultList);
        }
    }

    private void searchByCategory(ArrayList<Product> productList) {
        System.out.println("-------- Search By Category --------");
        String category = getInput.inputString("Enter product's category: ", "");
        ArrayList<Product> resultList = new ArrayList<>();
        // Loop to access from the first to the last product of the list
        for (Product product : productList) {
            // Compare user's entered category with category of product in the list, irrespective of the case
            if (product.getCategory().equalsIgnoreCase(category)) {
                resultList.add(product);
            }
        }
        if (resultList.isEmpty()) {
            System.out.println("No product found!");
        } else {
            System.out.println("Search result: ");
            display.displayProductList(resultList);
        }
    }

    private void searchByStorekeeper(ArrayList<Product> productList) {
        System.out.println("-------- Search By Storekeeper --------");
        String keeperName = getInput.inputString("Enter storekeeper's name: ", "");
        ArrayList<Product> resultList = new ArrayList<>();
        // Loop to access from the first to the last product of the list
        for (Product product : productList) {
            // Compare user's entered name with storekeeper's name of product in the list, irrespective of the case
            if (product.getStorekeeper().getStorekeeperName().equalsIgnoreCase(keeperName)) {
                resultList.add(product);
            }
        }
        if (resultList.isEmpty()) {
            System.out.println("No product found!");
        } else {
            System.out.println("Search result: ");
            display.displayProductList(resultList);
        }
    }

    private void searchByReceiptDate(ArrayList<Product> productList) {
        System.out.println("-------- Search By Receipt Date --------");
        Date receiptDate = getInput.inputDate("Enter product's receipt date: ");
        ArrayList<Product> resultList = new ArrayList<>();
        // Loop to access from the first to the last product of the list
        for (Product product : productList) {
            // Compare user's entered date with receipt date of product in the list
            if (product.getReceiptDate().equals(receiptDate)) {
                resultList.add(product);
            }
        }
        if (resultList.isEmpty()) {
            System.out.println("No product found!");
        } else {
            System.out.println("Search result: ");
            display.displayProductList(resultList);
        }
    }

}
