class Solution {
    // Please change the array in-place
    public void insertionSort(int arr[]) {
        // code here
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j > 0; j--) {
                if (arr[j-1] <= arr[j]) {
                    break;
                }
                swap(arr, j-1, j);
            }
        }
    }

    static void swap(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}