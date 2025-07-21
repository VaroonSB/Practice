class Solution {
    static int[][] dp;
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        dp = new int[arr.length][sum+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(arr, arr.length - 1, sum);
    }

    static boolean helper(int[] arr, int index, int target) {
        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return arr[index] == target;
        }

        if (dp[index][target] != -1) {
            return dp[index][target] == 1;
        }

        boolean not_take = helper(arr, index - 1, target);
        boolean take = false;
        if (target >= arr[index]) {
            take = helper(arr, index - 1, target - arr[index]);
        }

        boolean result = take || not_take;
        dp[index][target] = result ? 1 : 0;
        return result;
    }
}

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        boolean[][] dp = new boolean[n][sum+1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }

        for (int index = 1; index < n; index++) {
            for (int target = 1; target <= sum; target++) {
                boolean not_take = dp[index-1][target];
                boolean take = false;
                if (target >= arr[index]) {
                    take = dp[index-1][target - arr[index]];
                }

                dp[index][target] = take || not_take;
            }
        }


        return dp[n-1][sum];
    }
}

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
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