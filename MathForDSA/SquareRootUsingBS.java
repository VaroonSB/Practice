class Solution {
    public int mySqrt(int x) {
        int start = 0;
        int end = x;
        int res = start;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            long square = (long) mid * mid;
            if (square == x) {
                return mid;
            } else if (square > x) {
                end = mid - 1;
            } else if (square < x) {
                res = mid;
                start = mid + 1;
            }
        }
        return res;
    }
}