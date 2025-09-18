package com.gla;

import java.util.*;

public class EmployeeNames {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Aman", "Riya", "Karan");

        names.stream()
             .map(String::toUpperCase) // method reference
             .forEach(System.out::println);
    }
}

