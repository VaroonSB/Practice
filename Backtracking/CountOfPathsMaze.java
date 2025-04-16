class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        int left = uniquePaths(m-1, n);
        int right = uniquePaths(m, n-1);

        return left + right;
    }
}