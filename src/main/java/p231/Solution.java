package p231;

class Solution {
    public boolean isPowerOfTwo(int n) {
        long m = n;
        return m != 0 && (m & (m - 1)) == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPowerOfTwo(-2147483648));
    }
}
