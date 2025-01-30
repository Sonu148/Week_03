package day_02.hashmapsandhashfunctions;
import java.util.*;

public class LongestConsecutiveSubSequence {

        // Method to find the length of the longest consecutive sequence
        public static int longestConsecutive(int[] nums) {
            // To store unique elements
            Set<Integer> set = new HashSet<>();

            // Add all elements to the set
            for (int num : nums) {
                set.add(num);
            }

            int longest = 0;

            // Iterate through each number in the array
            for (int num : nums) {
                 if (!set.contains(num - 1)) {
                    // Start a new sequence from this number
                    int currentNum = num;
                    int count = 1;

                    // Check for consecutive numbers in the set
                    while (set.contains(currentNum + 1)) {
                        currentNum++;
                        count++;
                    }

                    // Update longest with the maximum sequence found so far
                    longest = Math.max(longest, count);
                }
            }

            // Return the length of the longest consecutive sequence
            return longest;
        }

        public static void main(String[] args) {
            int[] arr = {100, 4, 200, 1, 3, 2};
            System.out.println(longestConsecutive(arr));
        }
    }
