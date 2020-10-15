package p44;

import org.junit.Assert;

class Solution {

    public boolean isMatch(String s, String p) {
        System.out.println("s = " + s + ", p = " + p);
        int pos = 0;
        while (pos < s.length()
                && pos < p.length()
                && (p.charAt(pos) == '?' || p.charAt(pos) == s.charAt(pos))) {
            pos++;
        }
        if (pos == p.length()) return pos == s.length();
        if (p.charAt(pos) == '*') {
            for (int skip = 0; pos + skip <= s.length(); skip++) {
                if (isMatch(s.substring(pos + skip), p.substring(pos + 1))) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        long start = System.currentTimeMillis();
        Assert.assertFalse(s.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"));
        long duration = System.currentTimeMillis() - start;
        System.out.println("duration: " + duration);
    }
}
