package day_03.sorting;

public class JobApplicantBySalary {
        public static void heapSort(int[] arr) {
            int n = arr.length;
            // Build a max-heap
            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(arr, n, i);
            }
            // Extract elements from heap one by one
            for (int i = n - 1; i > 0; i--) {

                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                // Re-heapify the reduced heap
                heapify(arr, i, 0);
            }
        }

        // Ensures the subtree rooted at i is a max-heap
        private static void heapify(int[] arr, int n, int i) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // If left child is larger than root
            if (left < n && arr[left] > arr[largest]) largest = left;
            // If right child is larger than largest so far
            if (right < n && arr[right] > arr[largest]) largest = right;

            // If largest is not root, swap and continue heapifying
            if (largest != i) {
                int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;
                // Recurse to maintain the heap property
                heapify(arr, n, largest);
            }
        }

        public static void main(String[] args) {
            int[] salaries = { 50000, 70000, 60000, 55000, 75000 };
            // Sort the salary demands
            heapSort(salaries);
            // Print sorted salaries
            for (int salary : salaries) {
                System.out.print(salary + " ");
            }
        }
    }

