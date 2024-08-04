class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (1 <= val && val <= n) {
                int point = nums[val - 1];
                if (point > 0) {
                    nums[val - 1] *= -1;
                } else if (point == 0) {
                    nums[val - 1] = -1 * (n+1);
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            if (nums[i-1] >= 0) {
                return i;
            }
        }
        return n+1;
    }
}