package day_02.hashmapsandhashfunctions;
import java.util.*;
public class TwoSum {
    // Method to find two indices whose values add up to the target
    public static int[] findTwoSum(int[] nums, int target) {

        // Map to store number and its index
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // Check if the complement exists in the map
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }
        // No valid pair found
        return new int[]{-1, -1};
    }

    // Main function to test the code
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] result = findTwoSum(arr, target);
        System.out.println(Arrays.toString(result)); // [0,1]
    }
}
