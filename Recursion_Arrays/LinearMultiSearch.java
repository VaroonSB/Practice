import java.util.*;

class Main {

    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        linearMultiSearch(new int[]{4, 10, 8, 9, 8, 10}, 0, 10);
        System.out.println(list.toString());
    }

    static void linearMultiSearch(int[] arr, int i, int target) {

        if (i == arr.length) {
            return;
        }

        if (arr[i] == target) {
            list.add(i);
        }

        linearMultiSearch(arr, i+1, target);
    }
}