package day_03.sorting;

public class BookPrice {
    public static void mergeSort(int[] arr) {
        // Base case: if the array has fewer than two elements, it's already sorted
        if (arr.length < 2) return;

        // Find the middle of the array
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        // Copy data into left and right arrays
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        // Recursively sort the left and right half
         mergeSort(left);
         mergeSort(right);

        // Merge the sorted halves
        merge(arr, left, right);
    }

    // Merges two sorted arrays into the original array
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

         while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }

        // Copy remaining elements from left (if any)
        while (i < left.length) arr[k++] = left[i++];

        // Copy remaining elements from right (if any)
        while (j < right.length) arr[k++] = right[j++];
    }

    public static void main(String[] args) {
        int[] bookPrices = { 500, 200, 150, 400, 300 };
        // Sort the book prices
        mergeSort(bookPrices);
        // Print sorted book prices
        for (int price : bookPrices) {
            System.out.print(price + " ");
        }
    }
}

