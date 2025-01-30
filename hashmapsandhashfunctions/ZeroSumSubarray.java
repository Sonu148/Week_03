package day_02.hashmapsandhashfunctions;
import java.util.*;

public class ZeroSumSubarray {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        // Map to store cumulative sum and list of indices where it occurs
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int sum = 0;

        // Initialize with sum 0 at index -1 to capture Subarrays starting at index 0
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // Update cumulative sum

            // If this sum has been seen before, Subarrays exist
            if (sumMap.containsKey(sum)) {
                for (int start : sumMap.get(sum)) {
                    result.add(new int[]{start + 1, i}); // Store (start+1, i)
                }
            }

            // Add current index to the list of indices for this sum
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, 2}; // Sample array
        List<int[]> result = findZeroSumSubarrays(arr);

        if (result.isEmpty()) {
            System.out.println("No Subarrays found with sum zero.");
        } else {
            System.out.println("Zero-sum Subarrays:");
            for (int[] subarray : result) {
                System.out.println("Start: " + subarray[0] + ", End: " + subarray[1]);
            }
        }
    }
}
