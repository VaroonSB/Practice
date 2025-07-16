// User function Template for Java

class Solution {
    int[][] dp;
    public int maximumPoints(int arr[][]) {
        // code here
        dp = new int[arr.length][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return maximumPoints(arr, arr.length-1, 3);
    }

    int maximumPoints(int[][] arr, int day, int lastTask) {
        if (day == 0) {
            int max = 0;

            for (int i = 0; i < 3; i++) {
                if (lastTask != i) {
                    max = Math.max(max, arr[day][i]);
                }
            }

            return max;
        }

        if (dp[day][lastTask] != -1) {
            return dp[day][lastTask];
        }

        int max = 0;

        for (int task = 0; task < 3; task++) {
            if (task != lastTask) {
                int point = arr[day][task] + maximumPoints(arr, day - 1, task);
                max = Math.max(max, point);
            }
        }

        return dp[day][lastTask] = max;
    }
}

// User function Template for Java

class Solution {
    int[][] dp;
    public int maximumPoints(int arr[][]) {
        // code here
        int n = arr.length;
        dp = new int[arr.length][4];


        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = Math.max(arr[0][0], (Math.max(arr[0][1], arr[0][2])));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                int max = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = arr[day][task] + dp[day-1][task];
                        max = Math.max(max, point);
                    }
                }
                dp[day][last] = max;
            }
        }

        return dp[n-1][3];
    }
}

// User function Template for Java

class Solution {
    int[] prev;
    public int maximumPoints(int arr[][]) {
        // code here
        int n = arr.length;
        prev = new int[4];


        prev[0] = Math.max(arr[0][1], arr[0][2]);
        prev[1] = Math.max(arr[0][0], arr[0][2]);
        prev[2] = Math.max(arr[0][0], arr[0][1]);
        prev[3] = Math.max(arr[0][0], (Math.max(arr[0][1], arr[0][2])));

        for (int day = 1; day < n; day++) {
            int[] current = new int[4];
            for (int last = 0; last < 4; last++) {
                int max = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = arr[day][task] + prev[task];
                        max = Math.max(max, point);
                    }
                }
                current[last] = max;
            }
            prev = current;
        }
        return prev[3];
    }
}