package p392;

import org.junit.Assert;

import java.util.TreeSet;

class Solution {
    public boolean isSubsequence(String s, String t) {
        TreeSet<Integer>[] dic = new TreeSet[26];

        for (int i = 0; i < t.length(); i++) {
            int k = t.charAt(i) - 'a';
            if (dic[k] == null) {
                dic[k] = new TreeSet<>();
            }
            dic[k].add(i);
        }

        Integer x = 0;
        for (int i = 0; i < s.length(); i++) {
            TreeSet tree = dic[s.charAt(i) - 'a'];
            if (tree == null || tree.isEmpty()) {
                return false;
            }
            x = (Integer) tree.ceiling(x);
            if (x == null) {
                return false;
            }
            x += 1;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertFalse(s.isSubsequence("aaaaaa", "bbaaaa"));
        Assert.assertTrue(s.isSubsequence("abc", "ahbgdc"));
        Assert.assertFalse(s.isSubsequence("axc", "ahbgdc"));
    }
}
