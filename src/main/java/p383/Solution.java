package p383;

import org.junit.Assert;

class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] a = new int[26];
        int[] b = new int[26];

        for (int i = 0; i < ransomNote.length(); i++) {
            a[ransomNote.charAt(i) - 'a']++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            b[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (a[i] > b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertFalse(s.canConstruct("a", "b"));
        Assert.assertFalse(s.canConstruct("aa", "ab"));
        Assert.assertTrue(s.canConstruct("aa", "aab"));
    }

}
