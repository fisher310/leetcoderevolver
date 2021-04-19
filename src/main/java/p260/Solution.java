package p260;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lihailong
 * @since 2021/04/19 13:55:01
 */
class Solution {

    public int[] singleNumber(int[] nums) {

        int ret = 0;
        for (int x : nums) {
            ret ^= x;
        }

        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }

        int a = 0, b = 0;
        for (int x : nums) {
            if ((x & div) != 0) {
                a ^= x;
            } else {
                b ^= x;
            }
        }

        return new int[]{a, b};
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }
}
