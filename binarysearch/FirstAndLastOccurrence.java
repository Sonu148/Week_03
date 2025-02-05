package day_05.binarysearch;

import java.util.Arrays;

public class FirstAndLastOccurrence {
    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 2, 3, 4, 4, 5};
        int targetElement = 4;
        int[] occurrences = findFirstAndLastOccurrence(sortedArray, targetElement);
        System.out.println("First and last occurrence of " + targetElement + ": " + Arrays.toString(occurrences));
    }

    public static int[] findFirstAndLastOccurrence(int[] arr, int target) {
        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);
        return new int[]{first, last};
    }

    private static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                // Update result and search left
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // Return the first occurrence index
        return result;
    }

    private static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                // Update result and search right
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // Return the last occurrence index
        return result;
    }
}