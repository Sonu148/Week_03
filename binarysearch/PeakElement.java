package day_05.binarysearch;
public class PeakElement {
    public static void main(String[] args) {
        // input as array to find the peak element
        int[] peakArray = {1, 3, 20, 4, 1};
        // calling the method 
        int peakElement = findPeakElement(peakArray);
        System.out.println("Peak element: " + peakElement);
    }

    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                // Search left
                right = mid - 1;
            } else if (mid < arr.length - 1 && arr[mid] < arr[mid + 1]) {
                // Search right
                left = mid + 1;
            } else {
                // Peak element found
                return arr[mid];
            }
        }
        // Peak element found
        return arr[left];
    }
}