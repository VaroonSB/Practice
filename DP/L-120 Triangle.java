class Solution {
    Integer[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        dp = new Integer[triangle.size()][triangle.getLast().size()];
        return helper(triangle, 0, 0);
    }

    int helper(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int cost = triangle.get(i).get(j);
        int down = cost + helper(triangle, i + 1, j);
        int diagonal = cost + helper(triangle, i + 1, j + 1);

        return dp[i][j] = Math.min(down, diagonal);
    }
}

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[n-1][j] = triangle.getLast().get(j);
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = dp[i+1][j];
                int diagonal = dp[i+1][j+1];

                dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
            }
        }

        return dp[0][0];
    }
}

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        for (int j = 0; j < n; j++) {
            dp[j] = triangle.getLast().get(j);
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int down = dp[j];
                int diagonal = dp[j + 1];

                dp[j] = triangle.get(i).get(j) + Math.min(down, diagonal);
            }
        }

        return dp[0];
    }
}