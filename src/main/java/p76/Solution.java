package p76;

import java.util.HashMap;
import java.util.Map;

/** 最小覆盖子串 */
class Solution {
    private Map<Character, Integer> map;
    private int count = 0;

    public String minWindow(String s, String t) {
        map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        count = t.length();

        int i = 0, j = 0;
        String ans = "";
        char[] arr = s.toCharArray();
        int len = arr.length;
        while (i < len) {
            if (j - i < count) {
                if (j < len ) {
                    j++;
                    continue;
                } else {
                    break;
                }
            }
            if (containsAll(arr, i, j)) {
                if ("".equals(ans) || ans.length() > j - i) {
                    ans = new String(arr, i, j - i);
                }
                i++;
            } else if (j < len) {
                j++;
            } else {
                i++;
            }
        }

        return ans;
    }

    boolean containsAll(char[] arr, int i, int j) {
        Map<Character, Integer> tmpMap = new HashMap<>();
        int tmpCount = 0;
        for (int k = i; k < j; k++) {
            Integer mc = map.get(arr[k]);
            if (mc == null) continue;
            Integer cnt = tmpMap.getOrDefault(arr[k], 0);
            if (cnt < mc) {
                tmpCount++;
                tmpMap.put(arr[k], cnt + 1);
            }
        }
        return tmpCount == count;
    }
}
