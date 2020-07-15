package m0714;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {

        Map<Character, Character> map = new HashMap<>();

        List<String> res = new ArrayList<>();
        outer:
        for (String word : words) {

            map.clear();
            for (int i = 0; i < word.length(); i++) {
                if (map.containsKey(word.charAt(i))) {
                    if (map.get(word.charAt(i)) != pattern.charAt(i)) {
                        continue outer;
                    }
                } else if (map.containsValue(pattern.charAt(i))) {
                    continue outer;
                }
                map.put(word.charAt(i), pattern.charAt(i));
            }

            res.add(word);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();

        System.out.println(
                s.findAndReplacePattern(new String[] {"ef", "fq", "ao", "at", "lx"}, "ya"));
        System.out.println(
                s.findAndReplacePattern(
                        new String[] {"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb"));
    }
}
