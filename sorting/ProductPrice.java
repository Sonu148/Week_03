package day_03.sorting;

public class ProductPrice {
        public static void quickSort(int[] arr, int low, int high) {
            // Recursively apply QuickSort if the array has more than one element
            if (low < high) {
                int pivotIndex = partition(arr, low, high);
                quickSort(arr, low, pivotIndex - 1);
                quickSort(arr, pivotIndex + 1, high);
            }
        }

        // Partitions the array around a pivot, elements < pivot are on left, > pivot on right
        private static int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = low - 1;

            // Loop through the array, rearranging elements based on the pivot
            for (int j = low; j < high; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            // Swap pivot with element at i+1 to place it in correct position
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
            return i + 1;
        }

        public static void main(String[] args) {
            int[] productPrices = { 300, 100, 500, 200, 400 };
            // Sort the product prices
            quickSort(productPrices, 0, productPrices.length - 1);
            // Print sorted product prices
            for (int price : productPrices) {
                System.out.print(price + " ");
            }
        }
    }

