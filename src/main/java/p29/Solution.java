package p29;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * <p>返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * <p>整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * <p>
 *
 * <p>示例 1:
 *
 * <p>输入: dividend = 10, divisor = 3 输出: 3 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 示例 2:
 *
 * <p>输入: dividend = 7, divisor = -3 输出: -2 解释: 7/-3 = truncate(-2.33333..) = -2
 *
 * <p>提示：
 *
 * <p>被除数和除数均为 32 位有符号整数。 除数不为 0。 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^(31 − 1)]。本题中，如果除法结果溢出，则返回
 * 231 − 1。 通过次数39,963提交次数206,152
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 1) return dividend;
        if (divisor == -1) return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;

        if (divisor == Integer.MIN_VALUE) return dividend == Integer.MIN_VALUE ? 1 : 0;

        int ans = 0;
        boolean sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        if (dividend == Integer.MIN_VALUE) {
            dividend += Math.abs(divisor);
            ans++;
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        ans += div(dividend, divisor);

        return sign ? ans : -ans;
    }

    int div(int dividend, int divisor) {
        if (dividend < divisor) return 0;
        int ans = 1;
        int acc = divisor;
        while (dividend - acc >= acc) {
            ans += ans;
            acc += acc;
        }
        return ans + div(dividend - acc, divisor);
    }

    public static void main(String[] args) {
        System.out.println(-7 >> 1);
        System.out.println(-7 | 0x0FFFFFFF);
        System.out.println((~-7) + 1);
        System.out.println(Integer.toHexString(Integer.MAX_VALUE));
        System.out.println(Integer.toHexString(Integer.MIN_VALUE));
    }
}
