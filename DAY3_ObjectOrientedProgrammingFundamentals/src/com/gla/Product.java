package com.gla;
public class Product {
    private final int productID; 
    private String productName;
    private double price;
    private int quantity;
    private static double discount = 0.0; 

    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

 
    public static void updateDiscount(double newDiscount) {
        if (newDiscount >= 0 && newDiscount <= 100) {
            discount = newDiscount;
        } else {
            System.out.println("Invalid discount percentage");
        }
    }

   
    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getProductID() {
        return productID;
    }

    
    public double getDiscountedPrice() {
        return price * (1 - discount / 100);
    }

    
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", discount=" + discount + "%" +
                '}';
    }
    public static void main(String[] args) {
        Product product1 = new Product(1, "Laptop", 1200.00, 10);
        Product product2 = new Product(2, "Smartphone", 800.00, 20);

        // original products
        System.out.println("Before discount:");
        System.out.println(product1);
        System.out.println(product2);

        // Update the discount percentage
        Product.updateDiscount(10); // 10% discount

        // Display products after applying discount
    
        System.out.println(product1);
        System.out.println(product2);

        // Access details
        System.out.println(product1.getDiscountedPrice());
        System.out.println(product2.getDiscountedPrice());

       
        product1.setProductName("Gaming Laptop");
        product1.setPrice(1500.00);
        product1.setQuantity(5);

        System.out.println("\nUpdated Product 1:");
        System.out.println(product1);
    }
}