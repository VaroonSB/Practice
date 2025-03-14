class Solution {
    public int splitArray(int[] nums, int k) {
        int start = Integer.MIN_VALUE;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            end += nums[i];
            start = Math.max(start, nums[i]);
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int piece = 1;
            int sum = 0;
            for (int num: nums) {
                if (sum + num > mid) {
                    sum = num;
                    piece++;
                } else {
                    sum += num;
                }
            }

            if (piece > k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}