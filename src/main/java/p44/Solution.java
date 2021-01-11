package p44;

import org.junit.Assert;

class Solution {

    private String str;
    private String pattern;
    // 1 match, 2 not match
    private int[][] cache;

    public boolean isMatch(String s, String p) {
        this.str = s;
        this.pattern = p;
        cache = new int[s.length() + 1][p.length() + 1];
        return helper(0, 0);
    }

    private boolean helper(int s, int p) {
        if (cache[s][p] != 0) return cache[s][p] == 1;
        if (s < str.length()
                && p < pattern.length()
                && (str.charAt(s) == pattern.charAt(p) || pattern.charAt(p) == '?')) {
            return helper(s + 1, p + 1);
        }

        if (p == pattern.length()) {
            int ret = s == str.length() ? 1 : 2;
            cache[s][p] = ret;
            return ret == 1;
        }

        if (pattern.charAt(p) == '*') {
            if (helper(s, p + 1) || (s < str.length() && helper(s + 1, p))) {
                return true;
            }
        }

        cache[s][p] = 2;
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertTrue(s.isMatch("aa", "*"));
        long start = System.currentTimeMillis();
        Assert.assertFalse(
                s.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"));
        long duration = System.currentTimeMillis() - start;
        System.out.println("duration: " + duration);

        start = System.currentTimeMillis();
        s.isMatch(
                "aabbbaabbabbbabbabbbaaabaaababbababaabbababaaaaabbaababbabaabbbaaabaaaabbbabaaabbabaaaaaaaababbaaaaabbbaabbabbaabbbbabbababbbabbbababbababaabaaabbababbababbbbaabaaababbbbbababbbbaaaaaaabbbabbbbbbabbaba",
                "**a*abbbb*a*ba****ba**a**a*ba**a****aaa**abaa****aa**aaaa*bbbbbaaa*bb**aaabaaaa*aab*ab*aaabbb*b**a*aa*a");
        duration = System.currentTimeMillis() - start;
        System.out.println("duration: " + duration);
    }
}
