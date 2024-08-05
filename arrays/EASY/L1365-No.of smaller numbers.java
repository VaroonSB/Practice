class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        int[] result = new int[nums.length];
        Arrays.sort(temp);
        for(int i = 0; i < nums.length; i++) {
            int index = Arrays.binarySearch(temp, nums[i]);
            int count = 0;
            for (int j = index-1; j >= 0; j--) {
                if (nums[i] > temp[j]) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}