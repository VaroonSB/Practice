class Solution {
    void selectionSort(int[] arr) {
        // code here
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                int minimum = min(arr, i, arr.length);
                if (minimum == i) {
                    continue;
                }
                swap(arr, i, minimum);
            }
        }
    }

    static void swap(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

    static int min(int[] arr, int start, int end) {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = start; i < end; i++) {
            if (min > arr[i]) {
                min = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}