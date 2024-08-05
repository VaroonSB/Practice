class Solution {
    public int largestAltitude(int[] gain) {
        int[] res = new int[gain.length];
        int max = 0;
        int currentHeight = 0;
        for(int i = 0; i < res.length; i++) {
            res[i] = currentHeight + gain[i];
            currentHeight += gain[i];
            if(res[i] > max) {
                max = res[i];
            }
        }
        return max;
    }
}