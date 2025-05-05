class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 < n2) {
            return find(nums2, nums1);
        } else {
            return find(nums1, nums2);
        }
    }

    int[] find(int[] arr, int[] targets) {
        int[] result = new int[targets.length];
        Arrays.sort(arr);
        Arrays.sort(targets);
        int n = arr.length;
        int j = 0;

        for (int i: targets) {
            if (binarySearch(arr, i, n-1)) {
                if (j > 0 && result[j-1] == i) {
                    continue;
                }
                result[j++] = i;
            }
        }

        return Arrays.copyOf(result, j);
    }

    boolean binarySearch(int[] arr, int target, int length) {
        int start = 0;
        int end = length;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}