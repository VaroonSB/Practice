class Solution1250 {
    public boolean isGoodArray(int[] nums) {
        int result = nums[0];
        for (int num : nums) {
            result = gcd(result, num);
            if (result == 1) {
                return true;
            }
        }
        return false;
    }
    static int gcd(int a, int b) {
         int gcd = Math.min(a, b);
         while (gcd > 0) {
             if(a % gcd == 0 && b % gcd == 0) {
                 return gcd;
             }
             gcd--;
         }
         return gcd;
    }
}