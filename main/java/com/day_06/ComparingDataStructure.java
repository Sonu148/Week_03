package com.day_06;
import java.util.*;

public class ComparingDataStructure {

    public static void main(String[] args) {
        // Dataset size
        int n = 1000000;
        int[] arr = new int[n];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Fill datasets
        for (int i = 0; i < n; i++) {
            arr[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        // Array search performance
        long startTime = System.nanoTime();
        // Linear search
        boolean foundInArray = Arrays.binarySearch(arr, n - 1) >= 0;
        long endTime = System.nanoTime();
        System.out.println("Array search time: " + (endTime - startTime)  + " ns");

        // HashSet search performance
        startTime = System.nanoTime();
        boolean foundInHashSet = hashSet.contains(n - 1);
        endTime = System.nanoTime();
        System.out.println("HashSet search time: " + (endTime - startTime)+ " ns");

        // TreeSet search performance
        startTime = System.nanoTime();
        boolean foundInTreeSet = treeSet.contains(n - 1);
        endTime = System.nanoTime();
        System.out.println("TreeSet search time: " + (endTime - startTime)  + " ns");
    }
}
