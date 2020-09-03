package p171;

import org.junit.Assert;

class Solution {

    public int titleToNumber(String s) {
        int ans = 0;
        char[] ch = s.toCharArray();
        for (int i = ch.length - 1; i >=0; i--) {
            ans += (ch[i] - 'A' + 1) * Math.pow(26, ch.length - 1 - i);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(26, s.titleToNumber("Z"));
        Assert.assertEquals(701, s.titleToNumber("ZY"));
    }
}
