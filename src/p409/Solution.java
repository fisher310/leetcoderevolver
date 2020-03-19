package p409;

import java.util.Map;
import java.util.HashMap;
/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * <p>在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * <p>注意: 假设字符串的长度不会超过 1010。
 *
 * <p>示例 1:
 *
 * <p>输入: "abccccdd"
 *
 * <p>输出: 7
 *
 * <p>解释: 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int total = 0;
        int odd = 0;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() % 2 == 0) {
                total += e.getValue();
            } else {
                total += e.getValue() - 1;
                odd = odd > 0 ? odd : 1;
            }
        }
        return total + odd;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //        System.out.println(s.longestPalindrome("abccccdd"));
        System.out.println(s.longestPalindrome("ccd"));
    }
}
