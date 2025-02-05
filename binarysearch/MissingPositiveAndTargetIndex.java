package day_05.binarysearch;

public class MissingPositiveAndTargetIndex {
    public static void main(String[] args) {
        int[] numbers = {3, 4, -1, 1};
        int firstMissingPositive = findFirstMissingPositive(numbers);
        System.out.println("First missing positive integer: " + firstMissingPositive);

        int[] sortedArray = {1, 2, 2, 3, 4, 4, 5};
        int targetIndex = 4;
        int indexOfTarget = binarySearch(sortedArray, targetIndex);
        System.out.println("Index of target " + targetIndex + ": " + indexOfTarget);
    }

    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                // Swap arr[i] with arr[arr[i] - 1]
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                // Return the first missing positive integer
                return i + 1;
            }
        }
        // If all numbers are present
        return n + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                // Target found
                return mid;
            } else if (arr[mid] < target) {
                // Search right
                left = mid + 1;
            } else {
                // Search left
                right = mid - 1;
            }
        }
        // Target not found
        return -1;
    }
}