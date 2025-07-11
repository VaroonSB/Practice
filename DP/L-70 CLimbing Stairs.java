class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return solution(n, dp);
    }

    static int solution(int n, int[] dp) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = solution(n-1, dp) + solution(n-2, dp);
    }
}