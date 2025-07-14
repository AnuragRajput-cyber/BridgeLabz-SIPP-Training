package com.gla;
import java.util.*;

public class DataStructureSearch {

    public static void runStructureComparison() {
        int size = 1_000_000;
        List<Integer> list = new ArrayList<>();
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            int val = i;
            list.add(val);
            hashSet.add(val);
            treeSet.add(val);
        }

        int target = size - 1;

        long start = System.nanoTime();
        list.contains(target);
        System.out.println("ArrayList (O(N)): " + (System.nanoTime() - start) / 1e6 + " ms");

        start = System.nanoTime();
        hashSet.contains(target);
        System.out.println("HashSet (O(1)): " + (System.nanoTime() - start) / 1e6 + " ms");

        start = System.nanoTime();
        treeSet.contains(target);
        System.out.println("TreeSet (O(log N)): " + (System.nanoTime() - start) / 1e6 + " ms");
    }
}

