class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}

/**
 * Other Approaches
 * 1. Interger.bitCount(n)
 * 2. n & (n-1) -> removes right most set bit. Instead of gointhrough each bit,
 * counting while removing right most set bit is efficient.
 */