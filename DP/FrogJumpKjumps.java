// User function Template for Java
class Solution {

    int minCost(int[] height) {
        // code here
        return minCost(height, height.length - 1, 3);
    }

    int minCost(int[] height, int index, int k) {
        if (index == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (index - i >= 0) {
                int cost =
                        Math.abs(height[index - i] - height[index]) + minCost(height, index - i, k);
                min = Math.min(min, cost);
            }
        }

        return min;
    }
}

// User function Template for Java
class Solution {
    int[] dp;

    int minCost(int[] height) {
        // code here
        dp = new int[height.length];
        Arrays.fill(dp, -1);
        return minCost(height, height.length - 1, 3);
    }

    int minCost(int[] height, int index, int k) {
        if (index == 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (index - i >= 0) {
                int cost =
                        Math.abs(height[index - i] - height[index]) + minCost(height, index - i, k);
                min = Math.min(min, cost);
            }
        }

        return dp[index] = min;
    }
}

// User function Template for Java
class Solution {
    int[] dp;

    int minCost(int[] height) {
        // code here
        int n = height.length dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int cost = Math.abs(height[i - j] - height[i]) + dp[i - j];
                    min = Math.min(min, cost);
                }
            }
            dp[i] = min;
        }

        return dp[n - 1];
    }
}