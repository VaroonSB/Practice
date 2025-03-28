class Solution {
    public boolean search(int[] nums, int target) {
        int pivot = findPivot(nums);
        
        if (pivot == -1) {
            return binarySearch(nums, 0, nums.length-1, target);
        } else if (target == nums[pivot]) {
            return true;
        } else if (target >= nums[0]) {
            return binarySearch(nums, 0, pivot-1, target);
        } else {
            return binarySearch(nums, pivot+1, nums.length-1, target);
        }
    }

    static boolean binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == nums[mid]) {
                return true;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            System.out.println(start);
            System.out.println(end);
            System.out.println(mid);
            if (mid < end && nums[mid] > nums[mid+1]) {
                return mid;
            } else if (mid > start && nums[mid] < nums[mid-1]) {
                return mid - 1;
            } else if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                if (start < end && nums[start] > nums[start+1]) {
                    return start;
                }
                start++;
                if (end > start && nums[end] < nums[end-1]) {
                    return end-1;
                }
                end--;
            } else if (nums[mid] > nums[start] || (nums[mid] == nums[start] && nums[mid] > nums[end] )) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}