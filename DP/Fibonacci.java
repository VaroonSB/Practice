package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciDP {
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(memoization(n, dp));

        System.out.println(bottomUp(n));

        System.out.println(spaceOptimized(n));
    }

    static int memoization(int num, int[] dp) {
        if (num <= 1) {
            return num;
        }

        if (dp[num] != -1) {
            return dp[num];
        }
        return dp[num] = memoization(num - 1, dp) + memoization(num - 2, dp);
    }

    static int bottomUp(int num) {
        int[] dp = new int[num + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[num];
    }

    static int spaceOptimized(int num) {
        int prev1 = 0;
        int prev2 = 1;

        for (int i = 2; i <= num; i++) {
            int current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }

        return prev2;
    }
}
