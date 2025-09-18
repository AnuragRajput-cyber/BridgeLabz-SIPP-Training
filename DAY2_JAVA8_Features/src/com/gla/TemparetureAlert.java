package com.gla;

import java.util.function.Predicate;

public class TemparetureAlert {
    public static void main(String[] args) {
        Predicate<Double> isHigh = temp -> temp > 40.0;

        System.out.println(isHigh.test(35.5)); // false
        System.out.println(isHigh.test(45.2)); // true
    }
}

