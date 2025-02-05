package day_05.binarysearch;
public class RotationPoint {
    public static void main(String[] args) {
        // input as array
        int[] rotatedArray = {4, 5, 6, 7, 0, 1, 2};

        // calling the method
        int rotationPointIndex = findRotationPoint(rotatedArray);
        // display the result
        System.out.println("Rotation point index: " + rotationPointIndex);
    }

    public static int findRotationPoint(int[] arr) {
        // initialise the left and right
        int left = 0, right = arr.length - 1;
        // checking the condition
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[right]) {
                // The smallest element is in the right half
                left = mid + 1;
            } else {
                // The smallest element is in the left half
                right = mid;
            }
        }
        // The rotation point index
        return left;
    }
}