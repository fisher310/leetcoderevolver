package offer48;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();

        final char[] ch = s.toCharArray();

        int ans = 0;
        int start = 0;
        for (int i = 0; i < ch.length; i++) {
            if (map.containsKey(ch[i])) {
                ans = Math.max(ans, i - start);
                start = Math.max(start, map.get(ch[i]) + 1);
            }
            map.put(ch[i], i);
        }
        ans = Math.max(ans, ch.length - start);
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        Assert.assertEquals(2, s.lengthOfLongestSubstring("abba"));
        Assert.assertEquals(3, s.lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, s.lengthOfLongestSubstring("aaaaa"));
        Assert.assertEquals(3, s.lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals(3, s.lengthOfLongestSubstring("abc"));
        Assert.assertEquals(2, s.lengthOfLongestSubstring("aac"));
    }
}
