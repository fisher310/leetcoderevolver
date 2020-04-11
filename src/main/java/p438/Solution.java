package p438;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/** 找到字符串中所有字母异位词 */
class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0 || s.length() < p.length()) return Collections.emptyList();
        int[] pm = new int[26];
        int[] sm = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pm[p.charAt(i) - 'a']++;
            sm[s.charAt(i) - 'a']++;
        }

        List<Integer> ans = new LinkedList<>();
        if (matches(pm, sm)) ans.add(0);
        int l = 0, r = p.length();
        while (r < s.length()) {
            sm[s.charAt(r++) - 'a']++;
            sm[s.charAt(l++) - 'a']--;
            if (matches(pm, sm)) {
                ans.add(l);
            }
        }
        return ans;
    }

    private boolean matches(int[] pm, int[] sm) {
        for (int i = 0; i < 26; i++) {
            if (pm[i] != sm[i]) {
                return false;
            }
        }
        return true;
    }
}
