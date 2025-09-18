package com.gla;
import java.util.*;
import java.util.stream.*;

class Order {
    String customer;
    double total;
    Order(String customer, double total) {
        this.customer = customer;
        this.total = total;
    }
    String getCustomer() { return customer; }
    double getTotal() { return total; }
}

public class OrderSummary {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("Aman", 200.0),
                new Order("Neha", 150.0),
                new Order("Aman", 300.0),
                new Order("Ravi", 100.0)
        );

        Map<String, Double> revenue = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer,
                        Collectors.summingDouble(Order::getTotal)));

        System.out.println(revenue);
    }
}

