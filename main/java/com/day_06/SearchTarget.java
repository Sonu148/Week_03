package com.day_06;
import java.util.Arrays;

public class SearchTarget {

     public static int linearSearch(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                return i;
            }
        }
        return -1;
    }

     public static int binarySearch(int[] arr, int n) {
        int length = arr.length;
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == n) {
                return mid;
            } else if (arr[mid] < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

     public static int[] generateRandomDataSet(int size) {
        int[] dataSet = new int[size];
        for (int i = 0; i < size; i++) {
            dataSet[i] = (int) (Math.random() * 10 * size);
        }
        return dataSet;
    }

     public static void comparePerformance(int size, int n) {
        int[] dataset = generateRandomDataSet(size);

        // Linear Search Performance
        long startTime = System.nanoTime();
        linearSearch(dataset, n);
        long endTime = System.nanoTime();
        long linearTime = endTime - startTime;

        // Sorting the array before Binary Search
        Arrays.sort(dataset);

        // Binary Search Performance
        startTime = System.nanoTime();
        binarySearch(dataset, n);
        endTime = System.nanoTime();
        long binaryTime = endTime - startTime;

        System.out.println("Dataset Size: " + size);
        System.out.println("Linear Search Time: " + linearTime + " ns");
        System.out.println("Binary Search Time: " + binaryTime + " ns");
         System.out.println();
    }

    public static void main(String[] args) {
        int n = 999;
        comparePerformance(1000, n);
        comparePerformance(10000, n);
        comparePerformance(1000000, n);
    }
}
