import java.util.*;

class Main {

    static int[] arr = {9, 3, 5, 1, 4, 2};

    public static void main(String[] args) {
        System.out.print(Arrays.toString(mergeSort(arr)));
    }

    static int[] mergeSort(int[] arr) {

        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] first, int[] second) {
        int i = 0; // first;
        int j = 0; // second;
        int k = 0; // result;

        int[] result = new int[first.length + second.length];

        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                result[k] = first[i];
                i++;
            } else {
                result[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < first.length) {
            result[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length) {
            result[k] = second[j];
            j++;
            k++;
        }

        return result;
    }

}