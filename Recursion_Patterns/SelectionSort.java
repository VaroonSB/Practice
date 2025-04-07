import java.util.*;

class Main {

    static int[] arr = {9, 3, 5, 1, 4, 2};

    public static void main(String[] args) {
        selectionSort(0, 0, 0);
        System.out.print(Arrays.toString(arr));
    }

    static void selectionSort(int pointer, int index, int min) {

        if(pointer == arr.length - 1) {
            return;
        }

        if (index < arr.length) {
            if (arr[index] < arr[min]) {
                selectionSort(pointer, index+1, index);
            } else {
                selectionSort(pointer, index+1, min);
            }
        } else {
            swap(arr, pointer, min);
            selectionSort(pointer + 1, pointer+1, pointer+1);
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}