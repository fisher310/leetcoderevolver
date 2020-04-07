package p136;

/**
 * <h>只出现一次的数字 </h>
 *
 * <p>a ^ 0 = a <br>
 * a ^ a = 0 <br>
 * a ^ b ^ a = (a ^ a) ^ b= b <br>
 * 异或满足交换律和结合律
 */
class Solution {
  public int singleNumber(int[] nums) {
    int a = 0;
    for (int n : nums) {
      a ^= n;
    }
    return a;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int ans = solution.singleNumber(new int[] {2, 2, 1});
    System.out.println(ans);
  }
}
