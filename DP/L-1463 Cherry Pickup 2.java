class Solution {
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n][n];
        for (int[][] entry : dp) {
            for (int[] row : entry) {
                Arrays.fill(row, -1);
            }
        }
        return helper(grid, 0, 0, n - 1);
    }

    int helper(int[][] grid, int i, int j1, int j2) {
        if (j1 < 0 || j2 < 0 || j1 >= grid[0].length-1 || j2 > grid[0].length-1) {
            return Integer.MIN_VALUE;
        }

        if (i == grid.length - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            }
            return grid[i][j1] + grid[i][j2];
        }

        if(dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }

        // explore all paths
        int max = Integer.MIN_VALUE;
        for (int dj1 = -1; dj1 <= +1; dj1++) {
            for (int dj2 = -1; dj2 <= +1; dj2++) {
                int value = 0;
                if (j1 == j2) {
                    value = grid[i][j1];
                } else {
                    value = grid[i][j1] + grid[i][j2];
                }
                value += helper(grid, i+1, j1 + dj1, j2 + dj2);
                max = Math.max(value, max);
            }
        }

        return dp[i][j1][j2] = max;
    }
}


class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for (int[][] entry : dp) {
            for (int[] row : entry) {
                Arrays.fill(row, -1);
            }
        }

        // base case
        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                if (j1 == j2) {
                    dp[m-1][j1][j2] = grid[m-1][j1];
                } else {
                    dp[m-1][j1][j2] = grid[m-1][j1] + grid[m-1][j2];
                }
            }
        }

        for (int i = m-2; i >= 0; i--) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {

                    int max = Integer.MIN_VALUE;

                    for (int dj1 = -1; dj1 <= +1; dj1++) {
                        for (int dj2 = -1; dj2 <= +1; dj2++) {
                            int value = 0;
                            if (j1 == j2) {
                                value = grid[i][j1];
                            } else {
                                value = grid[i][j1] + grid[i][j2];
                            }
                            if (j1 + dj1 >= 0 && j1 + dj1 < n && j2 + dj2 >= 0 && j2 + dj2 < n) {
                                value += dp[i+1][j1 + dj1][j2 + dj2];
                            } else {
                                value = (int) Math.pow(-10, 9);
                            }

                            max = Math.max(value, max);
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }

        return dp[0][0][n-1];
    }
}



class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] prev = new int[n][n];

        // base case
        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                if (j1 == j2) {
                    prev[j1][j2] = grid[m-1][j1];
                } else {
                    prev[j1][j2] = grid[m-1][j1] + grid[m-1][j2];
                }
            }
        }

        for (int i = m-2; i >= 0; i--) {
            int[][] curr = new int[n][n];
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {

                    int max = Integer.MIN_VALUE;

                    for (int dj1 = -1; dj1 <= +1; dj1++) {
                        for (int dj2 = -1; dj2 <= +1; dj2++) {
                            int value = 0;
                            if (j1 == j2) {
                                value = grid[i][j1];
                            } else {
                                value = grid[i][j1] + grid[i][j2];
                            }
                            if (j1 + dj1 >= 0 && j1 + dj1 < n && j2 + dj2 >= 0 && j2 + dj2 < n) {
                                value += prev[j1 + dj1][j2 + dj2];
                            } else {
                                value = (int) Math.pow(-10, 9);
                            }

                            max = Math.max(value, max);
                        }
                    }
                    curr[j1][j2] = max;
                }
            }
            prev = curr;
        }

        return prev[0][n-1];
    }
}

