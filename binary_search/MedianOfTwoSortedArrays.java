class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] nums = new int[n];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                nums[k] = nums1[i];
                i++;
            } else {
                nums[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < nums1.length) {
            nums[k] = nums1[i];
            i++;
            k++;
        }

        while (j < nums2.length) {
            nums[k] = nums2[j];
            j++;
            k++;
        }

        if (n % 2 == 0) {
            return (nums[n/2] + nums[n/2 - 1]) / 2.0;
        }

        return nums[n/2];
    }
}