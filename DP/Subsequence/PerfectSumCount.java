class Solution {
    // Function to calculate the number of subsets with a given sum
    int[][] dp;
    public int perfectSum(int[] nums, int target) {
        // code here
        dp = new int[nums.length][target+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(nums, nums.length - 1, target);
    }

    int helper(int[] nums, int index, int sum) {
        if (index == 0) {
            if (sum == 0 && nums[0] == 0) {
                return 2; // take and not take
            }
            if (sum == 0 || sum == nums[0]) {
                return 1;
            }
            return 0;
        }

        if (dp[index][sum] != -1) {
            return dp[index][sum];
        }

        int not_pick = helper(nums, index - 1, sum);
        int pick = 0;
        if (nums[index] <= sum) {
            pick = helper(nums, index - 1, sum - nums[index]);
        }

        return dp[index][sum] = pick + not_pick;
    }
}


class Solution {
    // Function to calculate the number of subsets with a given sum
    int[][] dp;
    public int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        dp = new int[nums.length][target+1];


        dp[0][0] = 1;

        if (nums[0] == 0) {
            dp[0][0] = 2;
        }

        if (nums[0] != 0 && nums[0] <= target) {
            dp[0][nums[0]] = 1;
        }

        for (int index = 1; index < n; index++) {
            for (int sum = 0; sum <= target; sum++) {
                int not_pick = dp[index - 1][sum];
                int pick = 0;
                if (nums[index] <= sum) {
                    pick = dp[index - 1][sum - nums[index]];
                }

                dp[index][sum] = pick + not_pick;
            }
        }

        return dp[n-1][target];
    }
}
