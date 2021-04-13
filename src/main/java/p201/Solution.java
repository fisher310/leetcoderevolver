package p201;

/**
 * [5, 7] -> 4
 * [1, 2147483647] -> 0
 * <p>
 * 101
 * 110
 * 111
 *
 * @author lihailong
 * @since 2021/04/13 16:34:14
 */
class Solution {

    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right &= (right - 1);
        }
        return right;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rangeBitwiseAnd(4, 6));
    }
}
