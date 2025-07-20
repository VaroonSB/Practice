class Solution {
    int[] dp;

    public int numSquares(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n);
    }

    int helper(int n) {
        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int minCount = Integer.MAX_VALUE;

        for (int i = 1; (i * i) <= n; i++) {
            int result = helper(n - (i * i));
            // result + 1 because 1 for i*i used
            minCount = Math.min(minCount, result + 1);
        }

        return dp[n] = minCount;
    }
}

class Solution {
    int[] dp;
    public int numSquares(int n) {
        dp = new int[n+1];

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; (j*j) <= i; j++) {
                min = Math.min(min, 1 + dp[i - (j * j)]);
            }
            dp[i] = min;
        }

        return dp[n];
    }
}

