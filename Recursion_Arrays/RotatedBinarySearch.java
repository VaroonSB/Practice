class Main {

    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 1, 2, 3, 4};
        System.out.println(rotatedBS(arr, 0, arr.length-1, 9));
    }

    static int rotatedBS(int[] arr, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (target == arr[mid]) {
            return mid;
        }

        if (arr[start] <= arr[mid]) {
            if (arr[start] <= target && target <= arr[mid]) {
                return rotatedBS(arr, start, mid - 1, target);
            } else {
                return rotatedBS(arr, mid + 1, end, target);
            }
        }

        if (arr[mid] <= target && target <= arr[end]) {
            return rotatedBS(arr, mid+1, end, target);
        } else {
            return rotatedBS(arr, start, mid - 1, target);
        }
    }
}