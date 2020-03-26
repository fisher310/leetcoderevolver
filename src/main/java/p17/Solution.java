package p17;

import java.util.*;

class Solution {
    Map<Character, List<Character>> map = new HashMap<>(8);

    Solution() {
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    private List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        dfs(digits.toCharArray(), 0, new StringBuilder());

        return ans;
    }

    void dfs(char[] ch, int i, StringBuilder s) {
        if (i == ch.length) {
            ans.add(s.toString());
            return;
        }

        List<Character> chars = map.get(ch[i]);
        for (char c : chars) {
            dfs(ch, i + 1, s.append(c));
            s.setLength(s.length() - 1);
        }
    }
}
