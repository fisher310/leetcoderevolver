package p1529;

import org.junit.Assert;

class Solution {

    public int minFlips(String target) {
        int times = 0;
        int N = target.length();
        for (int i = 0; i < N; i++) {
            if ((target.charAt(i) == '0' && times % 2 == 1)
                    || ((target.charAt(i) == '1') && times % 2 == 0)) {
                times++;
            }
        }

        return times;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(3, s.minFlips("10111"));
        Assert.assertEquals(3, s.minFlips("101"));
        Assert.assertEquals(3, s.minFlips("101"));
        Assert.assertEquals(0, s.minFlips("000000"));
        Assert.assertEquals(5, s.minFlips("001011101"));
    }
}
