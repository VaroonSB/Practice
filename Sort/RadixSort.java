import java.util.Arrays;

public class RadixSort {

    // Main function to do Radix Sort
    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        // Do counting sort for every digit (exp = 1, 10, 100, ...)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    // A utility function to get the maximum value in the array
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int value : arr) {
            if (value > max)
                max = value;
        }
        return max;
    }

    // A function to do counting sort based on digit represented by exp
    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // output array
        int[] count = new int[10]; // for digits 0 to 9

        // Count occurrences of digits
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Change count[i] so that it contains the actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array (stable sort)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy the output array to arr[]
        System.arraycopy(output, 0, arr, 0, n);
    }

    // Test it
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        radixSort(arr);
        System.out.println("After sorting:  " + Arrays.toString(arr));
    }
}
