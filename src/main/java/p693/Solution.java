package p693;

/**
 * @author lihailong
 * @since 2021/1/15 0015
 */
class Solution {

    public boolean hasAlternatingBits(int n) {
        int pre = n & 1;
        n = n >> 1;
        while (n != 0) {
            int cur = n & 1;
            if (cur == pre) return false;
            pre = cur;
            n = n >> 1;
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println(Integer.toBinaryString(~n));
        System.out.println(5 >>> 1 == ~n);
        Solution s = new Solution();
        System.out.println(s.hasAlternatingBits(5));
    }
}
