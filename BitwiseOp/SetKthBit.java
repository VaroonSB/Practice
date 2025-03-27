class Solution {
    static int setKthBit(int n, int k) {
        return n | (1 << (k));
    }

    static int resetKthBit(int n, int k) {
        return n & (1 << (k));
    }
}