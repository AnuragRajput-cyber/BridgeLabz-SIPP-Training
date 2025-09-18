package com.gla;

import java.util.*;

public class SuprressWarningExample {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List list = new ArrayList(); // raw type
        list.add("Hello");
        list.add(100); // no warning because of @SuppressWarnings

        System.out.println(list);
    }
}

