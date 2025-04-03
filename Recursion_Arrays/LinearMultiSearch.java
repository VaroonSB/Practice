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

import java.util.*;

class Main {

    public static void main(String[] args) {
        System.out.println(linearMultiSearch(new int[]{4, 10, 8, 9, 8, 10}, 0, 8));
    }

    static ArrayList linearMultiSearch(int[] arr, int i, int target) {

        ArrayList<Integer> list = new ArrayList<>();

        if (i == arr.length) {
            return list;
        }

        if (arr[i] == target) {
            list.add(i);
        }

        ArrayList<Integer> stackList = linearMultiSearch(arr, i+1, target);

        list.addAll(stackList);

        return list;
    }
}