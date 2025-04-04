class Main {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(pivot(arr, 0, arr.length-1));
    }

    static int pivot(int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (mid < end && arr[mid] > arr[mid + 1]) {
            return mid;
        } else if (mid > start && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        }

        if (arr[mid] >= arr[start]) {
            return pivot(arr, mid + 1, end);
        } else {
            return pivot(arr, start, mid - 1);
        }
    }
}