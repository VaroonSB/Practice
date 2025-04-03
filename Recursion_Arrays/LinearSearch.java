class Main {
    public static void main(String[] args) {
        System.out.println(linearSearch(new int[]{4, 11, 8, 9, 10}, 0, 8));
    }

    static int linearSearch(int[] arr, int i, int target) {

        if (i == arr.length - 1) {
            return -1;
        }

        if (arr[i] == target) {
            return i;
        }

        return linearSearch(arr, i+1, target);
    }
}