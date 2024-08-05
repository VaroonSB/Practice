class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }
        int[] target = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            target[i] = list.get(i);
        }
        return target;
    }

    static int[] insertElement(int[] arr, int index, int element) {
        int[] newArr = new int[arr.length+1];
        for(int i = 0; i < newArr.length; i++) {
            if(i < index) {
                newArr[i] = arr[i];
            } else if(i == index) {
                newArr[i] = element;
            } else {
                newArr[i] = arr[i-1];
            }
        }
        return newArr;
    }
}