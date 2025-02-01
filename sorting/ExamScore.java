package day_03.sorting;

public class ExamScore {
        public static void selectionSort(int[] arr) {
            // Loop through the array to find the smallest element in the unsorted part
            for (int i = 0; i < arr.length - 1; i++) {
                int minIdx = i;
                // Find the index of the minimum element in the unsorted part
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[minIdx]) {
                        minIdx = j;
                    }
                }
                // Swap the found minimum element with the first unsorted element
                int temp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = temp;
            }
        }

        public static void main(String[] args) {
            int[] examScores = { 80, 60, 90, 70, 85 };
            // Sort the exam scores
            selectionSort(examScores);
            // Print sorted exam scores
            for (int score : examScores) {
                System.out.print(score + " ");
            }
        }
    }

