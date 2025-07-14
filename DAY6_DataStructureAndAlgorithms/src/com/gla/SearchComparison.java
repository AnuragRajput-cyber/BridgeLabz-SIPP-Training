package com.gla;
import java.util.*;

public class SearchComparison {

    public static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }

    public static boolean binarySearch(int[] arr, int target) {
        Arrays.sort(arr);
        return Arrays.binarySearch(arr, target) >= 0;
    }

    public static void runSearchComparison() {
        int size = 1_000_000;
        int[] dataset = new Random().ints(size, 1, size * 10).toArray();
        int target = dataset[new Random().nextInt(size)];

        long start = System.nanoTime();
        linearSearch(dataset, target);
        System.out.println("Linear Search Time: " + (System.nanoTime() - start) / 1e6 + " ms");

        start = System.nanoTime();
        binarySearch(dataset, target);
        System.out.println("Binary Search Time: " + (System.nanoTime() - start) / 1e6 + " ms");
    }
}
