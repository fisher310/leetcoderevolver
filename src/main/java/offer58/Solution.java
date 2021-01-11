package offer58;

import org.junit.Assert;

class Solution {

    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals("cdefgab", s.reverseLeftWords("abcdefg", 2));
        Assert.assertEquals("umghlrlose", s.reverseLeftWords("lrloseumgh", 6));
    }
}
