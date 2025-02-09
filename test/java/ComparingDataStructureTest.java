import com.day_06.ComparingDataStructure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class ComparingDataStructureTest {

    @Test
    public void testArraySearch() {
        // Test small dataset for array search
        int n = 1000;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        // Test searching for the last element
        int target = n - 1;
        boolean foundInArray = Arrays.binarySearch(arr, target) >= 0;

        // Assert that the last element is found
        Assertions.assertTrue(foundInArray, "Element not found in array!");
    }

    @Test
    public void testHashSetSearch() {
        // Test small dataset for HashSet search
        int n = 1000;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add(i);
        }

        // Test searching for the last element
        int target = n - 1;
        boolean foundInHashSet = hashSet.contains(target);

        // Assert that the last element is found
        Assertions.assertTrue(foundInHashSet, "Element not found in HashSet!");
    }

    @Test
    public void testTreeSetSearch() {
        // Test small dataset for TreeSet search
        int n = 1000;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            treeSet.add(i);
        }

        // Test searching for the last element
        int target = n - 1;
        boolean foundInTreeSet = treeSet.contains(target);

        // Assert that the last element is found
        Assertions.assertTrue(foundInTreeSet, "Element not found in TreeSet!");
    }

    @Test
    public void testPerformance() {
        // Test performance for small dataset (1000 elements)
        int n = 1000;

        // Start performance test for array search (binarySearch)
        long startTime = System.nanoTime();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        Arrays.binarySearch(arr, n - 1); // Searching for the last element
        long endTime = System.nanoTime();
        long arraySearchTime = endTime - startTime;

        // Start performance test for HashSet search (contains)
        startTime = System.nanoTime();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add(i);
        }
        hashSet.contains(n - 1); // Searching for the last element
        endTime = System.nanoTime();
        long hashSetSearchTime = endTime - startTime;

        // Start performance test for TreeSet search (contains)
        startTime = System.nanoTime();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            treeSet.add(i);
        }
        treeSet.contains(n - 1); // Searching for the last element
        endTime = System.nanoTime();
        long treeSetSearchTime = endTime - startTime;

        // Assert that each search operation finishes within a reasonable time
        // Since this is a small dataset, we expect the operations to be very fast
        Assertions.assertTrue(arraySearchTime < 1000000, "Array search took too long!");
        Assertions.assertTrue(hashSetSearchTime < 1000000, "HashSet search took too long!");
        Assertions.assertTrue(treeSetSearchTime < 1000000, "TreeSet search took too long!");

        System.out.println("Array search time: " + arraySearchTime + " ns");
        System.out.println("HashSet search time: " + hashSetSearchTime + " ns");
        System.out.println("TreeSet search time: " + treeSetSearchTime + " ns");
    }
}
