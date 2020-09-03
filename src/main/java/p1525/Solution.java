package p1525;

import org.junit.Assert;

/**
 * aacaba
 */
class Solution {

    public int numSplits(String s) {

        int[] left = new int[26];
        int[] right = new int[26];

        char[] ch = s.toCharArray();
        for (char c : ch) {
            right[c - 'a']++;
        }

        int l = 0, r = 0;
        for (int i = 0; i < right.length; i++) {
            if (right[i] > 0) r++;
        }
        int ans = 0;
        for (int i = 0; i < ch.length; i++) {
            if (++left[ch[i] - 'a'] == 1) r--;
            if (--right[ch[i] - 'a'] == 0) l++;
            if (l == r) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(2, s.numSplits("aacaba"));
        Assert.assertEquals(1, s.numSplits("abcd"));
        Assert.assertEquals(4, s.numSplits("aaaaa"));
        Assert.assertEquals(2, s.numSplits("acbadbaada"));
    }
}
