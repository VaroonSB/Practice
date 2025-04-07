import java.util.*;

class Main {

    static int[] arr = {9, 3, 5, 1, 4, 2};

    public static void main(String[] args) {
        mergeSort(arr, 0, arr.length);
        System.out.print(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int start, int end) {

        if (end - start == 1) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);

        merge(arr, start, mid, end);
    }

    static void merge(int[] arr, int start, int mid, int end) {
        int i = start; // first;
        int j = mid; // second;
        int k = 0; // result;

        int[] mix = new int[end - start];

        while (i < mid && j < end) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < mid) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j < end) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[start + l] = mix[l];
        }
    }

}