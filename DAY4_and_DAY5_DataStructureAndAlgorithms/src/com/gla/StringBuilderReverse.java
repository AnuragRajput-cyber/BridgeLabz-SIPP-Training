package com.gla;

public class StringBuilderReverse {
    public static String reverse(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String result = reverse("hello");
        System.out.println("Reversed: " + result);
    }
}




