package com.gla;

import java.util.*;

class Product {
    String name;
    double price;
    double rating;

    Product(String name, double price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String toString() {
        return name + " - $" + price + " - Rating: " + rating;
    }
}

public class EcommersSort {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 800, 4.5),
            new Product("Phone", 500, 4.7),
            new Product("Headphones", 100, 4.2)
        );

        // Sort by price (lambda comparator)
        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        System.out.println("Sorted by Price: " + products);

        // Sort by rating
        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
        System.out.println("Sorted by Rating: " + products);
    }
}

