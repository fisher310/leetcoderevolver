package p263;

import org.junit.Assert;

/** 丑数 */
class Solution {

    public boolean isUgly(int num) {

        if (num < 1) return false;

        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertTrue(s.isUgly(6));
        Assert.assertTrue(s.isUgly(8));
        Assert.assertFalse(s.isUgly(14));
    }
}
