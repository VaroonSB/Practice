import java.util.*;

class Main {

    static int[] arr = {5, 1, 4, 2, 9};

    public static void main(String[] args) {
        bubbleSort(arr.length - 1, 0);
        System.out.print(Arrays.toString(arr));
    }

    static void bubbleSort(int row, int col) {

        if(row == 0) {
            return;
        }

        if (col < row) {
            if (arr[col] > arr[col + 1]) {
                swap(arr, col, col+1);
            }
            bubbleSort(row, col+1);
        } else {
            bubbleSort(row - 1, 0);
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

import java.util.*;

class Main {

    static int[] arr = {9, 5, 1, 4, 2};

    public static void main(String[] args) {
        bubbleSort(1, 0);
        System.out.print(Arrays.toString(arr));
    }

    static void bubbleSort(int pass, int index) {

        if(pass == arr.length - 1) {
            return;
        }

        if (index < (arr.length - pass)) {
            if (arr[index] > arr[index + 1]) {
                swap(arr, index, index+1);
            }
            bubbleSort(pass, index+1);
        } else {
            bubbleSort(pass + 1, 0);
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}