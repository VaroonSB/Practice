class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int c_rem = nums[i] % k;
            for (int p_rem = 0; p_rem < k; p_rem++) {
                dp[p_rem][c_rem] = 1 + dp[c_rem][p_rem];
                max = Math.max(max, dp[p_rem][c_rem]);
            }
        }

        return max;
    }
}