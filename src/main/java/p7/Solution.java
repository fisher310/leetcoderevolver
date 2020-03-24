package p7;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * <p>示例 1:
 *
 * <p>输入: 123 输出: 321  示例 2:
 *
 * <p>输入: -123 输出: -321 示例 3:
 *
 * <p>输入: 120 输出: 21
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

  public int reverse(int x) {
    long ans = 0;
    while (x != 0) {
      ans = ans * 10 + x % 10;
      x /= 10;
      if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
        return 0;
      }
    }
    return (int) ans;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.reverse(123));
    System.out.println(s.reverse(-123));
    System.out.println(s.reverse(120));
    System.out.println(s.reverse(1534236469));
    System.out.println(s.reverse(-2147483648));
  }
}
