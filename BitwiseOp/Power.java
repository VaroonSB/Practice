class Solution {
    /**
     * all numbers can be represent in binary pos
     * power is used in terms of 2^pos.
     */
    public int power(int base, int power) {
        int res = 1;

        while (power > 0) {
            if ((power & 1) == 1) {
                res *= base;
            }
            base *= base;
            power >>= 1;
        }

        return res;
    }
}