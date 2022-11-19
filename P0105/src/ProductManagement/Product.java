/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductManagement;

import java.util.Date;

/**
 *
 * @author 10 pro 64bit
 */
class Product {

    private int productId;
    private String productName;
    private String location;
    private String category;
    private int price;
    private Date manufacturingDate;
    private Date expiryDate;
    private Storekeeper storekeeper;
    private Date receiptDate;

    public Product() {
    }

    public Product(int productId, String productName, String location, String category, int price, Date manufacturingDate, Date expiryDate, Storekeeper storekeeper, Date receiptDate) {
        this.productId = productId;
        this.productName = productName;
        this.location = location;
        this.category = category;
        this.price = price;
        this.manufacturingDate = manufacturingDate;
        this.expiryDate = expiryDate;
        this.storekeeper = storekeeper;
        this.receiptDate = receiptDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Storekeeper getStorekeeper() {
        return storekeeper;
    }

    public void setStorekeeper(Storekeeper storekeeper) {
        this.storekeeper = storekeeper;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

}
