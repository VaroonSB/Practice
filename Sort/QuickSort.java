import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] arr = {4, 9, 2, 6, 1, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.print(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;

        int pivot = arr[mid];

        while (start <= end) {
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }

            if (start <= end) { // can be violated, so again put here
                swap(arr, start, end);
                start++;
                end--;
            }
        }

        // now pivot is at correct index
        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }

    static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}