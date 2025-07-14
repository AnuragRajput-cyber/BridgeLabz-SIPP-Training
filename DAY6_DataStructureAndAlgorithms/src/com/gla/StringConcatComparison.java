package com.gla;

public class StringConcatComparison {

    public static void runConcatTest(int n) {
        String result = "";
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            result += "a"; // Immutable
        }
        System.out.println("String: " + (System.nanoTime() - start) / 1e6 + " ms");

        StringBuilder sb = new StringBuilder();
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        System.out.println("StringBuilder: " + (System.nanoTime() - start) / 1e6 + " ms");

        StringBuffer sf = new StringBuffer();
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            sf.append("a");
        }
        System.out.println("StringBuffer: " + (System.nanoTime() - start) / 1e6 + " ms");
    }
}

