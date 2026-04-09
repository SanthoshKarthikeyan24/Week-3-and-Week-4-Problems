import java.util.*;

public class Week3_and_Week4_Problems {

    static class Trade {
        String id;
        int volume;

        Trade(String id, int volume) {
            this.id = id;
            this.volume = volume;
        }

        public String toString() {
            return id + ":" + volume;
        }
    }

    // Merge Sort (ascending volume)
    static void mergeSort(Trade[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(Trade[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Trade[] L = new Trade[n1];
        Trade[] R = new Trade[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i].volume <= R[j].volume) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Quick Sort (descending volume)
    static void quickSort(Trade[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(Trade[] arr, int low, int high) {
        int pivot = arr[high].volume;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].volume > pivot) { // DESC
                i++;
                Trade temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Trade temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Merge two sorted arrays + total volume
    static Trade[] mergeTwoSorted(Trade[] a, Trade[] b) {
        Trade[] result = new Trade[a.length + b.length];
        int i = 0, j = 0, k = 0;
        int total = 0;

        while (i < a.length && j < b.length) {
            if (a[i].volume <= b[j].volume) {
                result[k++] = a[i];
                total += a[i].volume;
                i++;
            } else {
                result[k++] = b[j];
                total += b[j].volume;
                j++;
            }
        }

        while (i < a.length) {
            result[k++] = a[i];
            total += a[i].volume;
            i++;
        }

        while (j < b.length) {
            result[k++] = b[j];
            total += b[j].volume;
            j++;
        }

        System.out.println("Merged Total Volume: " + total);
        return result;
    }

    public static void main(String[] args) {

        Trade[] trades = {
                new Trade("trade3", 500),
                new Trade("trade1", 100),
                new Trade("trade2", 300)
        };

        // Merge Sort
        mergeSort(trades, 0, trades.length - 1);
        System.out.println("Merge Sorted (Asc): " + Arrays.toString(trades));

        // Quick Sort (Desc)
        quickSort(trades, 0, trades.length - 1);
        System.out.println("Quick Sorted (Desc): " + Arrays.toString(trades));

        // Merge two sorted lists
        Trade[] morning = {
                new Trade("m1", 100),
                new Trade("m2", 400)
        };

        Trade[] afternoon = {
                new Trade("a1", 200),
                new Trade("a2", 300)
        };

        Trade[] merged = mergeTwoSorted(morning, afternoon);
        System.out.println("Merged Trades: " + Arrays.toString(merged));
    }
}