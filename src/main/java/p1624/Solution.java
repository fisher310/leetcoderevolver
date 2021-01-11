package p1624;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                max = Math.max(i - map.get(ch) - 1, max);
            } else {
                map.put(ch, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(18, s.maxLengthBetweenEqualCharacters("mgntdygtxrvxjnwksqhxuxtrv"));
        Assert.assertEquals(0, s.maxLengthBetweenEqualCharacters("aa"));
        Assert.assertEquals(2, s.maxLengthBetweenEqualCharacters("abca"));
        Assert.assertEquals(-1, s.maxLengthBetweenEqualCharacters("cbzxy"));
        Assert.assertEquals(4, s.maxLengthBetweenEqualCharacters("cabbac"));
    }
}
