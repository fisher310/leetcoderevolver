package p290;

import java.util.HashMap;
import java.util.Map;

/** 单词规律 */
class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (str == null || pattern == null || str.length() == 0 || pattern.length() == 0)
            return false;

        char[] p = pattern.toCharArray();
        String[] s = str.split(" ");
        if (p.length != s.length) return false;

        Map<Character, String> map = new HashMap<>();
        for (int i = 0, N = p.length; i < N; i++) {
            if (!map.containsKey(p[i])) {
                if (map.containsValue(s[i])) return false;
                map.put(p[i], s[i]);
            } else if (!map.get(p[i]).equals(s[i])) {
                return false;
            }
        }
        return true;
    }
}
