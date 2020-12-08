package com.will.productquote.model;

import java.util.ArrayList;

public class Product {

    private int code;
    private String description;
    private String brand;
    private int stock;
    private double unitPrice;
    private double dozenPrice;

    public Product(int code, String description, String brand, int stock, double unitPricce, double dozenPrice) {
        this.code = code;
        this.description = description;
        this.brand = brand;
        this.stock = stock;
        this.unitPrice = unitPricce;
        this.dozenPrice = dozenPrice;


    }

    public static ArrayList<Product> getData() {
        ArrayList<Product>  myProducts = new ArrayList<>();
        myProducts.add(new Product(1001, "TECLADO","GENIUS", 10,10,7.00));
        myProducts.add(new Product(1002, "MOUSE","GENIUS", 50,8,5.60));
        myProducts.add(new Product(1003, "MONITOR","LG", 12,120,84.00));
        myProducts.add(new Product(1004, "LCD","LG", 4,380,266));
        myProducts.add(new Product(1005, "LAPIZ OPTICO","GENIUS", 14,25,17.50));
        myProducts.add(new Product(1006, "VIRTUAL GLASS","SHINECON", 24,20,14.00));
        myProducts.add(new Product(1007, "AP","TPLINK", 15,28.99,20.99));
        myProducts.add(new Product(1008, "IMPRESORA","EPSON", 14,350.5,245.35));
        myProducts.add(new Product(1009, "ESCANER","EPSON", 19,125,87.50));
        myProducts.add(new Product(1010, "COPIADORA","XEROX", 24,499.99,349.99));
        myProducts.add(new Product(1011, "UPS","TPLINK", 16,35,24.50));
        myProducts.add(new Product(1012, "TINTA LASER","EPSON", 25,15,10.50));
        myProducts.add(new Product(1013, "HARD DISK","TOSHIBA", 55,120.99,84.69));
        myProducts.add(new Product(1014, "AUDIFONOS","GENIUS", 26,29.99,20.99));

        return myProducts;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getDozenPrice() {
        return dozenPrice;
    }

    public void setDozenPrice(double dozenPrice) {
        this.dozenPrice = dozenPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                ", stock=" + stock +
                ", unitPrice=" + unitPrice +
                ", dozenPrice=" + dozenPrice +
                '}';
    }
}
