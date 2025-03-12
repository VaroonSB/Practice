import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 5, 4, 1, 2};
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    static void swap(int[] nums, int i, int value) {
        int temp = nums[i];
        nums[i] = nums[value];
        nums[value] = temp;
    }
}