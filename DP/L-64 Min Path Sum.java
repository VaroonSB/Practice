class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        return helper(grid, m - 1, n - 1);
    }

    int helper(int[][] grid, int m, int n) {
        if (m == 0 && n == 0) {
            return grid[m][n];
        }

        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[m][n] != 0) {
            return dp[m][n];
        }

        int up = helper(grid, m-1, n);
        int left = helper(grid, m, n-1);

        return dp[m][n] = grid[m][n] + Math.min(up, left);
    }
}

class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int left = Integer.MAX_VALUE;
                int up = Integer.MAX_VALUE;
                if (i > 0) {
                    up = dp[i-1][j];
                }
                if (j > 0) {
                    left = dp[i][j-1];
                }
                dp[i][j] = grid[i][j] + Math.min(up, left);
            }
        }

        return dp[m-1][n-1];
    }
}

class Solution {
    int[] dp;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[i][j];
                } else if (i == 0) {
                    dp[j] = grid[i][j] + dp[j-1]; // only way is from left
                } else if (j == 0) {
                    dp[j] = grid[i][j] + dp[j]; // only wat is from above //
                } else {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j-1]);
                }
            }
        }

        return dp[n-1];
    }
}