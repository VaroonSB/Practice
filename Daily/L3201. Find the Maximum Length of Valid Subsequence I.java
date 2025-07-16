class Solution {
    public int maximumLength(int[] nums) {
        int evenCount = 0;
        int oddCount = 0;
        int eoCount = 0;
        int oeCount = 0;

        boolean nextEvenForEO = false;
        boolean nextOddForOE = false;

        for (int num : nums) {
            if (num % 2 == 0) {
                evenCount++;
                if (nextEvenForEO) {
                    eoCount++;
                    nextEvenForEO = false;
                }
                if (!nextOddForOE) {
                    oeCount++;
                    nextOddForOE = true;
                }
            } else {
                oddCount++;
                if (nextOddForOE) {
                    oeCount++;
                    nextOddForOE = false;
                }
                if (!nextEvenForEO) {
                    eoCount++;
                    nextEvenForEO = true;
                }
            }
        }

        int max = Math.max(evenCount, oddCount);
        max = Math.max(max, oeCount);
        max = Math.max(max, eoCount);

        return max;
    }
}


// I don't understand this now

class Solution {
    public int maximumLength(int[] nums) {
        // dp[sum_parity][end_parity]
        int[][] dp = new int[2][2];

        for (int num : nums) {
            int p = num % 2; // current parity

            // Case 1: EVEN sum (e.g., even+even, odd+odd)
            // The previous element must have the same parity 'p'.
            dp[0][p] = dp[0][p] + 1;

            // Case 2: ODD sum (e.g., even+odd, odd+even)
            // The previous element must have the opposite parity '1-p'.
            dp[1][p] = dp[1][1 - p] + 1;
        }

        // The result is the maximum value found in our DP table.
        int res = 0;
        res = Math.max(res, dp[0][0]);
        res = Math.max(res, dp[0][1]);
        res = Math.max(res, dp[1][0]);
        res = Math.max(res, dp[1][1]);

        return res;
    }
}