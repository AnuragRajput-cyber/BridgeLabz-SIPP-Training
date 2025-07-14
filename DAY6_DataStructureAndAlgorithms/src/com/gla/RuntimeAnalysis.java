package com.gla;

public class RuntimeAnalysis {
    public static void main(String[] args) {
        System.out.println("1. Linear vs Binary Search:");
        SearchComparison.runSearchComparison();

        System.out.println("\n2. Sorting Comparison:");
        SortingComparison.runSortComparison();

        System.out.println("\n3. String Concatenation:");
        StringConcatComparison.runConcatTest(10000);

        System.out.println("\n4. Fibonacci Recursive vs Iterative:");
        FibonacciComparison.runFibonacciTest(30);

        System.out.println("\n5. Data Structure Search:");
        DataStructureSearch.runStructureComparison();
    }
}

