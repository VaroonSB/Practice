class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;

        long[] prefixMin = new long[3 * n];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long currentSum = 0;

        for (int i = 0; i < 3 * n; i++) {
            maxHeap.add(nums[i]);
            currentSum += nums[i];

            if (maxHeap.size() > n) {
                currentSum -= maxHeap.poll();
            }

            if (maxHeap.size() == n) {
                prefixMin[i] = currentSum;
            }
        }

        long[] suffixMax = new long[3 * n];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        currentSum = 0;

        for (int i = 3 * n - 1; i >= 0; i--) {
            minHeap.add(nums[i]);
            currentSum += nums[i];

            if (minHeap.size() > n) {
                currentSum -= minHeap.poll();
            }

            if (minHeap.size() == n) {
                suffixMax[i] = currentSum;
            }
        }

        long minDiff = Long.MAX_VALUE;

        for (int i = n; i <= 2 * n; i++) {
            long diff = prefixMin[i-1] - suffixMax[i];
            minDiff = Math.min(diff, minDiff);
        }

        return minDiff;
    }
}