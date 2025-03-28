class Solution {
    /**
     * AND with 1 will return the same bit
     * So, AND the kth bit with 1.
     * For that, left shift 1 by k-1 times for trialing 0s.
     */
    public int singleNumber(int num, int k) {
        int result = num & (1 << (k - 1));

        return result == 0 ? 0 : 1;
    }
}