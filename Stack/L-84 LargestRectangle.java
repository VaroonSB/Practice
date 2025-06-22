class Solution {
    public int largestRectangleArea(int[] heights) {
        // The stack will store indices of bars.
        // We maintain a monotonically increasing order of heights in the stack.
        Stack<Integer> stack = new Stack<>();

        int max = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {

            int currentHeight = (i == n) ? 0 : heights[i]; // i = 0, gets directly pushed onto stack

            // While stack is not empty AND the current bar is shorter than the bar at the top of the stack
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                // This means the bar at stack.peek() is bounded on the right by the current bar 'i'.
                // So, we can calculate its potential max area.
                max = getMax(heights, stack, max, i);
            }
            stack.push(i);
        }

        return max;
    }

    int getMax(int[] heights, Stack<Integer> stack, int max, int i) {
        int height = heights[stack.pop()];
        int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
        int rightBoundary = i; // current index
        int width = rightBoundary - leftBoundary - 1;
        int area = height * width;

        return Math.max(max, area);
    }
}