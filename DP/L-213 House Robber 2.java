class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        return Math.max(robHelper(nums, 1, n-1), robHelper(nums, 0, n-2));
    }

    int robHelper(int[] nums, int start, int end) {
        if (end - start == 0) {
            return nums[start];
        }
        int prev2 = nums[start];
        int prev1 = Math.max(nums[start+1], prev2);

        for (int i = start+2; i <= end; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev1;
            int current = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}