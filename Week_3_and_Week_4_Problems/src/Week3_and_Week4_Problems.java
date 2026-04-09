import java.util.*;

public class Week3_and_Week4_Problems {

    // Linear Search (unsorted)
    static boolean linearSearch(int[] arr, int target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear comparisons: " + comparisons);
                return true;
            }
        }

        System.out.println("Linear comparisons: " + comparisons);
        return false;
    }

    // Binary Search - find insertion point
    static int binaryInsertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return low; // insertion index
    }

    // Floor (largest <= target)
    static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int res = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= target) {
                res = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    // Ceiling (smallest >= target)
    static int ceil(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int res = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                res = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100};

        // Linear Search (unsorted example)
        boolean found = linearSearch(risks, 30);
        System.out.println("Linear search result: " + found);

        // Binary operations (sorted array)
        int insertionPoint = binaryInsertionPoint(risks, 30);
        int floorValue = floor(risks, 30);
        int ceilValue = ceil(risks, 30);

        System.out.println("Insertion index for 30: " + insertionPoint);
        System.out.println("Floor(30): " + floorValue);
        System.out.println("Ceil(30): " + ceilValue);
    }
}