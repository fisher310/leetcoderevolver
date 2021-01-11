package common.regex;

import org.junit.Assert;

class Solution {

    public boolean match(String w, String s) {
        int pos = 0;
        while (pos < s.length()
                && pos < w.length()
                && (w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos))) ++pos;
        // 无法在检索对应关系，则确认while循环结束的原因
        // 2. 已达到范式最后一个字符串的情况：字符创业大道了最后一个字符，则对应关系成立
        if (pos == w.length())
            return pos == s.length();
        // 4. 遇到 * 而结束循环的情况，查看 * 对应几个字符
        if (w.charAt(pos) == '*')
            for (int skip = 0; pos + skip <= s.length(); skip++) {
                if (match(w.substring(pos + 1), s.substring(pos + skip))) {
                    return true;
                }
            }

        return false;
    }

    public static void main(String[] args) {
        Solution s =new Solution();
        Assert.assertTrue(s.match("a*b", "aaab"));
    }
}
