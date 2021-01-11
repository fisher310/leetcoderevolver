package p10;

import org.junit.Assert;

class Solution {

    public boolean isMatch(String s, String p) {
        int pos = 0;
        while (pos < s.length()
                && pos < p.length()
                && (p.charAt(pos) == '.' || s.charAt(pos) == p.charAt(pos))) {
            pos++;
        }

        if (pos == p.length()) {
            return pos == s.length();
        }

        if (p.charAt(pos) == '*') {
            for (int skip = 0; pos + skip <= s.length(); skip++) {
                if (isMatch(s.substring(skip + pos), p.substring(pos + 1))) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertTrue(s.isMatch("aab", "c*a*b"));
        Assert.assertTrue(s.isMatch("ab", "a*b**"));
        Assert.assertTrue(s.isMatch("ab", "a*b"));

    }
}
