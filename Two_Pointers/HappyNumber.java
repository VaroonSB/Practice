class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
            if (fast == 1) {
                return true;
            }
        } while (slow != fast);

        return false;
    }

    int findSquare(int n) {
        int result = 0;
        while (n > 0) {
            int rem = n % 10;
            result += rem * rem;
            n /= 10;
        }
        return result;
    }
}