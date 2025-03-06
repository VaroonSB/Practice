class Solution {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int r = 0;
        int c = grid[0].length - 1;
        int count = 0;

        while (r < rows && c >= 0) {
            if (grid[r][c] < 0) {
                // TODO: consider reducing row as well
                c--;
                count += rows - r;
            } else {
                r++;
            }
        }
        return count;
    }
}