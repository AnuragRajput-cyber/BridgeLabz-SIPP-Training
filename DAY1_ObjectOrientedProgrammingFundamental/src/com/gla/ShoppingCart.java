package com.gla;

import java.util.ArrayList;

class CartItem {
    String itemName;
    double price;
    int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalCost() {
        return price * quantity;
    }
}

public class ShoppingCart {
    private ArrayList<CartItem> items = new ArrayList<>();

    public void addItem(String itemName, double price, int quantity) {
        items.add(new CartItem(itemName, price, quantity));
        System.out.println(quantity + " x " + itemName + " added to cart.");
    }

    
    public void removeItem(String itemName) {
        boolean removed = items.removeIf(item -> item.itemName.equalsIgnoreCase(itemName));
        if (removed) {
            System.out.println(itemName + " removed from cart.");
        } else {
            System.out.println(itemName + " not found in cart.");
        }
    }

    public void displayTotalCost() {
        double total = 0.0;
        System.out.println("---- Cart Items ----");
        for (CartItem item : items) {
            System.out.println(item.itemName + " x" + item.quantity + " = ₹" + item.getTotalCost());
            total += item.getTotalCost();
        }
        System.out.println("Total Cost: ₹" + total);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Book", 250.0, 2);
        cart.addItem("Pen", 10.0, 5);
        cart.displayTotalCost();
        cart.removeItem("Pen");
        cart.displayTotalCost();
    }
}

