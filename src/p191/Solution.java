package p191;

/**
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 */
class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n = n & (n - 1);
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // int n = 0b00000000000000000000000000001011;
        int n = 0b11111111111111111111111111111101;
        System.out.println(s.hammingWeight(n));
    }
}
