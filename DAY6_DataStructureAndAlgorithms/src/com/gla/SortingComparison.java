package com.gla;
import java.util.*;
public class SortingComparison {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void runSortComparison() {
        int size = 10000;
        int[] data1 = new Random().ints(size, 1, size * 10).toArray();
        int[] data2 = Arrays.copyOf(data1, data1.length);
        int[] data3 = Arrays.copyOf(data1, data1.length);

        long start = System.nanoTime();
        bubbleSort(data1);
        System.out.println("Bubble Sort: " + (System.nanoTime() - start) / 1e6 + " ms");

        start = System.nanoTime();
        Arrays.sort(data2);
        System.out.println("Quick/Merge Sort: " + (System.nanoTime() - start) / 1e6 + " ms");
    }
}

