package com.gla;

import java.util.*;
import java.util.stream.*;

class MethodReferenceExamples {
    public static void main(String[] args) {

        // 1.
        System.out.println("=== Hospital Patient ID Printing ===");
        List<String> patientIds = Arrays.asList("P101", "P102", "P103");
        patientIds.forEach(System.out::println); // Method reference

        // 2.
        System.out.println("\n=== Name Uppercasing ===");
        List<String> employees = Arrays.asList("john", "alice", "mark");
        employees.stream()
                 .map(String::toUpperCase) // Method reference
                 .forEach(System.out::println);

        // 3.
        System.out.println("\n=== Invoice Object Creation ===");
        List<Integer> transactionIds = Arrays.asList(101, 102, 103);
        List<Invoice> invoices = transactionIds.stream()
                                               .map(Invoice::new) // Constructor reference
                                               .collect(Collectors.toList());
        invoices.forEach(System.out::println);
    }
}

//Constructor
class Invoice {
    private int transactionId;
    public Invoice(int transactionId) {
        this.transactionId = transactionId;
    }
    @Override
    public String toString() {
        return "Invoice{transactionId=" + transactionId + "}";
    }
}

