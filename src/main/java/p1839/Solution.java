package p1839;
/**
 * private char[] vowel = new char[] {'a', 'e', 'i', 'o', 'u'};
 *
 * @author lihailong
 * @since 2021/04/28 17:03:50
 */
class Solution {

    public int longestBeautifulSubstring(String word) {

        int ans = 1;

        for (int i = 0; i < word.length(); i++) {
            char max = word.charAt(i);
            for (int j = i + 1; j < word.length(); j++) {
                if (word.charAt(j) >= max) {
                    max = word.charAt(j);
                } else {
                    ans = Math.max(ans, (j - i));
                    break;
                }
            }
        }

        return ans;
    }
}
