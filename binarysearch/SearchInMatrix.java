package day_05.binarysearch;

public class SearchInMatrix {
    public static void main(String[] args) {

        // input 2D array
        int[][] matrix = {
                {1, 3, 5},
                {7, 10, 12},
                {14, 16, 20}
        };
        // target is 10
        int target = 10;

        // calling the method
        boolean isFound = searchInMatrix(matrix, target);
        System.out.println("Target " + target + " found in matrix: " + isFound);
    }

    public static boolean searchInMatrix(int[][] matrix, int target) {
        // declare the rows and cols
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = matrix[mid / cols][ mid % cols];

            if (midValue == target) {
                // Target found
                return true;
            } else if (midValue < target) {
                // Search right
                left = mid + 1;
            } else {
                // Search left
                right = mid - 1;
            }
        }
        // Target not found
        return false;
    }
}