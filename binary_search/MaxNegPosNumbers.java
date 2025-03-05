class Solution {
    public int maximumCount(int[] nums) {
        int negCount = findHighestNeg(nums) + 1;
        int posCount = nums.length - findLeastPos(nums);

        return Math.max(negCount, posCount);
    }

    static int findHighestNeg(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= 0) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }

    static int findLeastPos(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int ans = nums.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= 0) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
}