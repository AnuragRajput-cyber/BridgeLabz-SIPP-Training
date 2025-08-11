package com.gla;

import java.util.*;
import java.util.function.*;

class LambdaExamples {
    public static void main(String[] args) {

        // 1. Smart Home
        System.out.println("=== Smart Home Lighting Automation ===");
        Runnable motionTrigger = () -> System.out.println("Lights ON - Motion detected");
        Runnable eveningTrigger = () -> System.out.println("Lights ON - Evening mode activated");
        Runnable voiceCommandTrigger = () -> System.out.println("Lights ON - Voice command received");

        motionTrigger.run();
        eveningTrigger.run();
        voiceCommandTrigger.run();

        // 2. Custom Sorting
        System.out.println("\n=== Custom Sorting in E-Commerce ===");
        List<Product> products = Arrays.asList(
            new Product("Laptop", 75000, 4.5, 10),
            new Product("Phone", 50000, 4.7, 15),
            new Product("Headphones", 3000, 4.3, 5)
        );

        // Sort by Price
        products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        System.out.println("Sorted by Price: " + products);

        // Sort by Rating
        products.sort((p1, p2) -> Double.compare(p2.getRating(), p1.getRating()));
        System.out.println("Sorted by Rating: " + products);

        // Sort by Discount
        products.sort((p1, p2) -> Integer.compare(p2.getDiscount(), p1.getDiscount()));
        System.out.println("Sorted by Discount: " + products);

        // 3. Notification Filtering
        System.out.println("\n=== Notification Filtering ===");
        List<String> alerts = Arrays.asList("Critical - Heart rate drop", "Normal - Checkup", "Critical - High BP");
        Predicate<String> criticalFilter = alert -> alert.startsWith("Critical");

        alerts.stream()
              .filter(criticalFilter)
              .forEach(System.out::println);
    }
}

// Ecommers
class Product {
    private String name;
    private double price;
    private double rating;
    private int discount;

    public Product(String name, double price, double rating, int discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }
    public double getPrice() { return price; }
    public double getRating() { return rating; }
    public int getDiscount() { return discount; }

    @Override
    public String toString() {
        return name + " (Price: " + price + ", Rating: " + rating + ", Discount: " + discount + "%)";
    }
}

