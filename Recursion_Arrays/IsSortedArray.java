class Main {
    public static void main(String[] args) {
        System.out.println(isSorted(new int[]{4, 11, 8, 9, 10}, 0));
    }

    static boolean isSorted(int[] arr, int i) {

        if (i >= arr.length-2) {
            return true;
        }

        if (arr[i] > arr[i+1]) {
            return false;
        }

        return isSorted(arr, i+1);
    }
}