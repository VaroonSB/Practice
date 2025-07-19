class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        dp = new int[row][col];

        dp[0][0] = 1;
        for (int i = 1; i < row; i++) {
            dp[i][0] = (obstacleGrid[i][0] != 1 && dp[i-1][0] == 1) ? 1 : 0;
        }

        for (int i = 1; i < col; i++) {
            dp[0][i] = (obstacleGrid[0][i] != 1 && dp[0][i-1] == 1) ? 1 : 0;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[row-1][col-1];
    }
}

class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        dp = new int[row][col];

        dp[0][0] = 1;
        for (int i = 1; i < row; i++) {
            dp[i][0] = (obstacleGrid[i][0] != 1 && dp[i-1][0] == 1) ? 1 : 0;
        }

        for (int i = 1; i < col; i++) {
            dp[0][i] = (obstacleGrid[0][i] != 1 && dp[0][i-1] == 1) ? 1 : 0;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[row-1][col-1];
    }
}

class Solution {
    int[] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        dp = new int[col];

        dp[0] = 1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }

                if (j > 0) {
                    dp[j] = dp[j] + dp[j-1];
                }
            }
        }

        return dp[col-1];
    }
}