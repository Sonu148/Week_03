package day_05.linearsearch;
public class FirstNegativeNumber {
    public static void main(String[] args) {
        // input array
        int[] intArray = {3, 5, -1, 2, 4};
        // calling the method
        int firstNegativeIndex = findFirstNegative(intArray);

        // display the result
        System.out.println("First negative number index: " + firstNegativeIndex);
    }

    // method for finding the first negative number
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                // Return the index of the first negative number
                return i;
            }
        }
        // Return -1 if no negative number is found
        return -1;
    }
}