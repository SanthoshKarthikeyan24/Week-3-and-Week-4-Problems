import java.util.*;

public class Week3_and_Week4_Problems {

    // Linear Search (first occurrence)
    static int linearSearch(String[] arr, String target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear comparisons: " + comparisons);
                return i;
            }
        }
        return -1;
    }

    // Find last occurrence using Linear Search
    static int linearSearchLast(String[] arr, String target) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                index = i;
            }
        }
        return index;
    }

    // Binary Search (any occurrence)
    static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                System.out.println("Binary comparisons: " + comparisons);
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Count occurrences using Binary Search expansion
    static int countOccurrences(String[] arr, String target) {
        int index = binarySearch(arr, target);
        if (index == -1) return 0;

        int count = 1;

        int left = index - 1;
        while (left >= 0 && arr[left].equals(target)) {
            count++;
            left--;
        }

        int right = index + 1;
        while (right < arr.length && arr[right].equals(target)) {
            count++;
            right++;
        }

        return count;
    }

    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        // Linear Search (unsorted)
        System.out.println("Linear First accB: index " + linearSearch(logs, "accB"));
        System.out.println("Linear Last accB: index " + linearSearchLast(logs, "accB"));

        // Sort for Binary Search
        Arrays.sort(logs);
        System.out.println("Sorted Logs: " + Arrays.toString(logs));

        // Binary Search
        int index = binarySearch(logs, "accB");
        int count = countOccurrences(logs, "accB");

        System.out.println("Binary accB: index " + index + ", count = " + count);
    }
}