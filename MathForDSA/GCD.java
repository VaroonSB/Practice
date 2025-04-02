class Solution {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i: nums) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }
        return gcd(min, max);
    }

    // Eucledian algo -> gcd(a, b) = gcd(b%a, a)
    static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }

        return gcd(b % a, a);
    }
}