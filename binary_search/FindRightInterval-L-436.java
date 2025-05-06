class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        int[][] startsWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            startsWithIndex[i][0] = intervals[i][0];
            startsWithIndex[i][1] = i;
        }

        Arrays.sort(startsWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            result[i] = binarySearch(startsWithIndex, intervals[i][1]);
        }

        return result;
    }

    int binarySearch(int[][] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid][0] == target) {
                return arr[mid][1];
            } else if (arr[mid][0] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (start == 0 || start >= arr.length) {
            return -1;
        }
        return arr[start][1];
    }
}