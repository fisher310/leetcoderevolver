package p1839;

import java.util.HashSet;
import java.util.Set;

/**
 * private char[] vowel = new char[] {'a', 'e', 'i', 'o', 'u'};
 *
 * <p>aeeeiiiioooauuuaeiou
 *
 * @author lihailong
 * @since 2021/04/28 17:03:50
 */
class Solution {

    public int longestBeautifulSubstring(String word) {

        int n = word.length();
        if (n < 5) return 0;
        int ans = 0;

        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < n) {
            set.clear();
            set.add(word.charAt(i));
            j = i + 1;
            while (j < n && word.charAt(j) >= word.charAt(j - 1)) {
                set.add(word.charAt(j));
                j++;
            }
            if (set.size() == 5) ans = Math.max(ans, j - i);
            i = j;
        }

        return ans;
    }
}
