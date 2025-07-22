class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        System.out.println(sum);
        if (sum % 2 != 0) {
            return false;
        }

        return isSubsetSum(nums, sum/2);
    }

    boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        boolean[] dp = new boolean[sum+1];

        dp[0] = true;


        if (arr[0] <= sum) {
            dp[arr[0]] = true;
        }

        for (int index = 1; index < n; index++) {
            boolean[] current = new boolean[sum+1];
            current[0] = true;
            for (int target = 1; target <= sum; target++) {
                boolean not_take = dp[target];
                boolean take = false;
                if (target >= arr[index]) {
                    take = dp[target - arr[index]];
                }

                current[target] = take || not_take;
            }
            dp = current;
        }


        return dp[sum];
    }
}