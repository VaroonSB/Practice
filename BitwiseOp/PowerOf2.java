class Solution {
    /**
     * Intuition
     * In binary numbers, only 1, 10, 100, 1000, etc can be powers of 2.
     *
     * Approach
     * 1000 = 111 + 1
     * So, 1000 & 111 is 0. i.e, (n & n-1) = 0. This is the required condition.
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n-1)) == 0;
    }
}