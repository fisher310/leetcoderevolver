package m56dot1;

import org.junit.Assert;

/**
 * 数组中数字出现的次数
 *
 * <p>输入：nums = [4,1,4,6] 输出：[1,6] 或 [6,1]
 */
class Solution {

    public int[] singleNumbers(int[] nums) {

        int res = 0;
        for (int n : nums) {
            res ^= n;
        }

        System.out.println(1 ^ 5);
        System.out.println(Integer.toBinaryString(res));
        int div = 1;
        while ((div & res) == 0) {
            div <<= 1;
        }

        System.out.println(Integer.toBinaryString(div));
        int a = 0, b = 0;
        for (int n : nums) {
            System.out.println((n & div) + ": " + Integer.toBinaryString(n & div));
            if ((n & div) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }

        return new int[] {a, b};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {1, 5}, s.singleNumbers(new int[] {1, 2, 5, 2}));
//        Assert.assertArrayEquals(new int[] {1, 6}, s.singleNumbers(new int[] {4, 1, 4, 6}));
    }
}
