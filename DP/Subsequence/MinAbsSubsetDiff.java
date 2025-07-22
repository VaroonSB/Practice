// User function Template for Java

class Solution {
    boolean[][] dp;
    public int minDifference(int arr[]) {
        // Your code goes here
        int n = arr.length;
        int total = Arrays.stream(arr).sum();

        dp = new boolean[n][total+1];
        buildSubsetDP(arr, total, n);

        int min = Integer.MAX_VALUE;
        // dp[n-1][col -> 0 ... total]
        for (int s1 = 0; s1 <= total/2; s1++) {
            if (dp[n-1][s1] == true) {
                int diff = Math.abs((total-s1) - s1); // abs diff of s1 and s2
                min = Math.min(min, diff);
            }
        }

        return min;
    }

    void buildSubsetDP(int arr[], int sum, int n) {

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
    }
}
