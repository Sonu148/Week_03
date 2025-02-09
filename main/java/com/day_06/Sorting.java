package com.day_06;

import java.util.Arrays;

public class Sorting {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    // Quick Sort
    public static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }

    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortHelper(arr, low, pi - 1);
            quickSortHelper(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap arr[i+1] and arr[high]
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Method to compare sorting algorithms
    public static void compareSortAlgorithms(int[] arr) {
        // Bubble Sort
        int[] arrBubble = Arrays.copyOf(arr, arr.length);
        long startTime = System.nanoTime();
        bubbleSort(arrBubble);
        long endTime = System.nanoTime();
        System.out.println("Bubble Sort Time: " + (endTime - startTime) / 1000000 + " ms");

        // Merge Sort
        int[] arrMerge = Arrays.copyOf(arr, arr.length);
        startTime = System.nanoTime();
        mergeSort(arrMerge);
        endTime = System.nanoTime();
        System.out.println("Merge Sort Time: " + (endTime - startTime) / 1000000 + " ms");

        // Quick Sort
        int[] arrQuick = Arrays.copyOf(arr, arr.length);
        startTime = System.nanoTime();
        quickSort(arrQuick);
        endTime = System.nanoTime();
        System.out.println("Quick Sort Time: " + (endTime - startTime) / 1000000 + " ms");
    }

    public static void main(String[] args) {
        // Example dataset sizes
        int[] smallDataset = generateRandomArray(1000);
        int[] mediumDataset = generateRandomArray(10000);
        int[] largeDataset = generateRandomArray(1000000);

        System.out.println("Sorting small dataset (1,000 elements):");
        compareSortAlgorithms(smallDataset);

        System.out.println("\nSorting medium dataset (10,000 elements):");
        compareSortAlgorithms(mediumDataset);

        System.out.println("\nSorting large dataset (1,000,000 elements):");
        compareSortAlgorithms(largeDataset);
    }

    // Helper method to generate random integer arrays
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            // Random values between 0 and 10,000
            arr[i] = (int) (Math.random() * 10000);
        }
        return arr;
    }
}
