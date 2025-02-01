package day_03.sorting;

public class EmployeeId {
        public static void insertionSort(int[] arr) {
            // Loop through elements from index 1 to the end
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                // Move elements that are greater than key one position to the right
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                // Place key in the correct position
                arr[j + 1] = key;
            }
        }

        public static void main(String[] args) {
            int[] employeeIDs = { 105, 102, 110, 107, 103 };
            // Sort the array
            insertionSort(employeeIDs);
            // Print sorted employee IDs
            for (int id : employeeIDs) {
                System.out.print(id + " ");
            }
        }
    }

