package p392;

import org.junit.Assert;

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        for (; i < s.length() && j < t.length();) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertTrue(s.isSubsequence("abc", "ahbgdc"));
        Assert.assertFalse(s.isSubsequence("axc", "ahbgdc"));
    }
}
