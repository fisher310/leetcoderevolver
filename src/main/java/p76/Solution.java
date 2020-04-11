package p76;

import java.util.HashMap;
import java.util.Map;

/** 最小覆盖子串 */
class Solution {

    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>(t.length());
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int required = map.size();

        int l = 0, r = 0;
        int[] res = new int[] {-1, 0, 0};
        char[] arr = s.toCharArray();
        int len = arr.length;
        Map<Character, Integer> tmp = new HashMap<>(t.length());
        int formed = 0;
        while (r < len) {
            if (map.containsKey(arr[r])) {
                int value = tmp.getOrDefault(arr[r], 0) + 1;
                tmp.put(arr[r], value);
                if (value == map.get(arr[r])) {
                    formed++;
                }
            }

            while (l <= r && formed == required) {
                if (res[0] == -1 || res[0] > r - l + 1) {
                    res = new int[] {r - l + 1, l, r};
                }
                if (tmp.containsKey(arr[l])) {
                    int newCnt = tmp.get(arr[l]) - 1;
                    if (newCnt < map.get(arr[l])) {
                        formed--;
                    }
                    tmp.put(arr[l], newCnt);
                }
                l++;
            }
            r++;
        }
        if (res[0] == -1) return "";

        return new String(arr, res[1], res[0]);
    }
}
