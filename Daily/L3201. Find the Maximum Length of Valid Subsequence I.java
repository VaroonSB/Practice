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