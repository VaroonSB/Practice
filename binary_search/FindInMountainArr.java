/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = peakIndex(mountainArr);
        int result = binarySearch(mountainArr, 0, peak, target);
        if (result == -1) {
            result = binarySearch(mountainArr, peak+1, mountainArr.length()-1, target);
        }
        return result;
    }

    static int peakIndex(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    static int binarySearch(MountainArray arr, int start, int end, int target) {
        boolean isAsc = arr.get(start) <= arr.get(end);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midElement = arr.get(mid);
            if (target == midElement) {
                return mid;
            } else if (isAsc) {
                if (target > midElement) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target > midElement) {
                    end = mid -1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}