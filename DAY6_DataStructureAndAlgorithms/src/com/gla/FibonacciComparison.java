package com.gla;

public class FibonacciComparison {

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void runFibonacciTest(int n) {
        long start = System.nanoTime();
        try {
            fibonacciRecursive(n);
            System.out.println("Recursive: " + (System.nanoTime() - start) / 1e6 + " ms");
        } catch (StackOverflowError e) {
            System.out.println("Recursive: Stack Overflow");
        }

        start = System.nanoTime();
        fibonacciIterative(n);
        System.out.println("Iterative: " + (System.nanoTime() - start) / 1e6 + " ms");
    }
}
