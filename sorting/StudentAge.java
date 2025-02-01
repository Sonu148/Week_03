package day_03.sorting;

public class StudentAge {
        public static void countingSort(int[] arr) {
            // Maximum age is 18
            int max = 18;
            // Minimum age is 10
            int min = 10;
            int range = max - min + 1;

            // Create count array to store the frequency of each age
            int[] count = new int[range];
            for (int i = 0; i < arr.length; i++) {
                count[arr[i] - min]++;
            }


            int index = 0;
            for (int i = 0; i < count.length; i++) {
                while (count[i]-- > 0) {
                    // Place the age in the correct position
                    arr[index++] = i + min;
                }
            }
        }

        public static void main(String[] args) {
            int[] studentAges = { 14, 10, 18, 12, 15, 10, 17 };
            // Sort the ages
            countingSort(studentAges);
            // Print sorted student ages
            for (int age : studentAges) {
                System.out.print(age + " ");
            }
        }
    }
