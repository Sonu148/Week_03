package day_02.hashmapsandhashfunctions;
import java.util.*;

public class PairSum {
    // method for the check the exist pair to target sum
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(target - num)) {
                return true;
            }
            // add current number to set
            set.add(num);
        }
        return false;
    }

    // maim method for running the program
    public static void main(String[] args) {
        // taking the array
        int[] arr = {8, 4, 7, 1, 5};
        int target = 9;
        // display the result
        System.out.println(hasPairWithSum(arr, target)); // true
    }
}
