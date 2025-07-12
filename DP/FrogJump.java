// User function Template for Java
class Solution {
    int[] dp;
    int minCost(int[] height) {
        // code here
        dp = new int[height.length];
        Arrays.fill(dp, -1);
        return solution(height, height.length - 1);
    }

    int solution(int[] height, int n) {
        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int jumpOne = Math.abs(height[n] - height[n-1]) + solution(height, n-1);
        int jumpTwo = Integer.MAX_VALUE;
        if (n > 1) {
            jumpTwo = Math.abs(height[n] - height[n-2]) + solution(height, n-2);
        }

        return dp[n] = Math.min(jumpOne, jumpTwo);
    }
}

// User function Template for Java
class Solution {
    int[] dp;
    int minCost(int[] height) {
        // code here
        int n = height.length;
        dp = new int[height.length];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        if (n > 1) {
            dp[1] = Math.abs(height[1] - height[0]);
        }

        for (int i = 2; i < n; i++) {
            int jumpOne = Math.abs(height[i] - height[i-1]) + dp[i-1];
            int jumpTwo = Math.abs(height[i] - height[i-2]) + dp[i-2];

            dp[i] = Math.min(jumpOne, jumpTwo);
        }

        return dp[n-1];
    }
}

// User function Template for Java
class Solution {
    int[] dp;
    int minCost(int[] height) {
        // code here
        int n = height.length;
        int sPrev = 0;
        int fPrev = 0;

        if (n > 1) {
            fPrev = Math.abs(height[1] - height[0]);
        }

        for (int i = 2; i < n; i++) {
            int jumpOne = Math.abs(height[i] - height[i-1]) + fPrev;
            int jumpTwo = Math.abs(height[i] - height[i-2]) + sPrev;
            int currentIndexMin = Math.min(jumpOne, jumpTwo);;
            sPrev = fPrev;
            fPrev = currentIndexMin;
        }

        return fPrev;
    }
}