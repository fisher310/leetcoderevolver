package p1116;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countCharacters(String[] words, String chars) {
        if(words == null || words.length == 0) {
            return 0;
        }
        Map<Character, Integer> table = new HashMap<>(chars.length());
        for (int i = 0, n = chars.length(); i < n; i++) {
            table.put(chars.charAt(i), table.getOrDefault(chars.charAt(i), 0) + 1);
        }

        int total = 0;

        Map<Character, Integer> map = new HashMap<>();
        outer: for (String word : words) {
            map.clear();
            for (int i = 0, n = word.length(); i < n; i++) {
                char c = word.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (table.get(c) == null || table.get(c) < map.get(c)) {
                    continue outer;
                }
            }
            total += word.length();
        }

        return total;
    }

    public static void main(String[] args) {
        // String[] words = new String[]{"cat","bt","hat","tree"};
        String[] words = new String[] { "hello", "world", "leetcode" };
        // String chars = "atach";
        String chars = "welldonehoneyr";
        Solution s = new Solution();
        System.out.println(s.countCharacters(words, chars));
    }
}