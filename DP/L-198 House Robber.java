class Solution {
    public int rob(int[] nums) {
        return rob(nums, nums.length - 1);
    }

    int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }

        int pick = nums[i] + rob(nums, i - 2);
        int notPick = rob(nums, i-1);

        return Math.max(pick, notPick);
    }
}

class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return rob(nums, nums.length - 1);
    }

    int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int pick = nums[i] + rob(nums, i - 2);
        int notPick = rob(nums, i-1);

        return dp[i] = Math.max(pick, notPick);
    }
}

class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int pick = nums[i] + dp[i-2];
            int notPick = dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }

        return dp[n-1];
    }
}

class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int prev2 = nums[0];
        int prev1 = Math.max(nums[1], nums[0]);

        for (int i = 2; i < n; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev1;
            int current = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}