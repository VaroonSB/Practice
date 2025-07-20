class Solution {
    Integer[][] dp;
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new Integer[m][n];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, helper(matrix, m-1, i));
        }

        return min;
    }

    int helper(int[][] matrix, int m, int n) {
        if (n < 0 || n > matrix[0].length - 1) {
            return Integer.MAX_VALUE;
        }

        if (m == 0) {
            return matrix[m][n];
        }

        if (dp[m][n] != null) {
            return dp[m][n];
        }

        int up = helper(matrix, m-1, n);
        int leftUp = helper(matrix, m-1, n-1);
        int rightUp = helper(matrix, m-1, n+1);

        return dp[m][n] = matrix[m][n] + Math.min(up, Math.min(leftUp, rightUp));
    }
}

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Integer[][] dp = new Integer[m][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = dp[i-1][j];
                int leftUp = j > 0 ? dp[i-1][j-1] : Integer.MAX_VALUE;
                int rightUp = j+1 < n ? dp[i-1][j+1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(leftUp, rightUp));
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[m-1][j]);
        }

        return min;
    }
}

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n];

        for (int j = 0; j < n; j++) {
            dp[j] = matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            int prev_leftUp = dp[0];
            for (int j = 0; j < n; j++) {
                int temp = dp[j];
                int up = dp[j];
                int leftUp = j > 0 ? prev_leftUp : Integer.MAX_VALUE;
                int rightUp = j+1 < n ? dp[j+1] : Integer.MAX_VALUE;

                dp[j] = matrix[i][j] + Math.min(up, Math.min(leftUp, rightUp));
                prev_leftUp = temp;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[j]);
        }

        return min;
    }
}