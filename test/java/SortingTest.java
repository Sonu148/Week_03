import com.day_06.Sorting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SortingTest {

    // Helper method to check if an array is sorted in ascending order
    private boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    // Test the bubble sort
    @Test
    public void testBubbleSort() {
        // Test with 1000 elements
        int[] arr = Sorting.generateRandomArray(1000);
        Sorting.bubbleSort(arr);
        Assertions.assertTrue(isSorted(arr), "Bubble Sort failed! Array is not sorted.");
    }

    // Test the merge sort
    @Test
    public void testMergeSort() {
        // Test with 1000 elements
        int[] arr = Sorting.generateRandomArray(1000);
        Sorting.mergeSort(arr);
        Assertions.assertTrue(isSorted(arr), "Merge Sort failed! Array is not sorted.");
    }

    // Test the quick sort
    @Test
    public void testQuickSort() {
        // Test with 1000 elements
        int[] arr = Sorting.generateRandomArray(1000);
        Sorting.quickSort(arr);
        Assertions.assertTrue(isSorted(arr), "Quick Sort failed! Array is not sorted.");
    }

    // Test the compareSortAlgorithms method
    @Test
    public void testCompareSortAlgorithms() {
        int[] arr = Sorting.generateRandomArray(1000);
        Sorting.compareSortAlgorithms(arr);
    }

     @Test
    public void testSortingPerformance() {
        int[] smallDataset = Sorting.generateRandomArray(1000);
        int[] mediumDataset = Sorting.generateRandomArray(10000);
        int[] largeDataset = Sorting.generateRandomArray(100000);

        System.out.println("Sorting small dataset (1,000 elements):");
        Sorting.compareSortAlgorithms(smallDataset);

        System.out.println("\nSorting medium dataset (10,000 elements):");
        Sorting.compareSortAlgorithms(mediumDataset);

        System.out.println("\nSorting large dataset (100,000 elements):");
        Sorting.compareSortAlgorithms(largeDataset);
    }

}
