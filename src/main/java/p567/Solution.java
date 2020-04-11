package p567;

/** 字符串的排列 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) return false;
        if (s1.length() > s2.length()) return false;

        int[] s1_map = new int[26];
        int[] s2_map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1_map[s1.charAt(i) - 'a']++;
            s2_map[s2.charAt(i) - 'a']++;
        }
        if (matches(s1_map, s2_map)) return true;
        for (int i = 0, j = s1.length(); j < s2.length(); i++, j++) {
            s2_map[s2.charAt(j) - 'a']++;
            s2_map[s2.charAt(i) - 'a']--;
            if (matches(s1_map, s2_map)) {
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] s1, int[] s2) {
        for (int i = 0; i < 26; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }
}
