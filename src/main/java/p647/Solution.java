package p647;

import org.junit.Assert;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * <p>具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * <p>示例 1:
 *
 * <p>输入: "abc" 输出: 3 解释: 三个回文子串: "a", "b", "c". 示例 2:
 *
 * <p>输入: "aaa" 输出: 6 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int countSubstrings(String s) {
        if (null == s || s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        char[] ch = s.toCharArray();

        int ans = 0;
        int len = ch.length;
        for (int i = 0; i < ch.length; i++) {

            ans += helperOdd(ch, i, len);
            ans += helperEven(ch, i, len);

        }
        return ans;
    }

    int helperEven(char[] arr, int i, int len) {
        int count = 0;
        int l = i, r = i + 1;
        while (l >= 0 && r < len) {
            if (arr[l--] == arr[r++])
                count++;
            else
                break;
        }
        return count;
    }

    int helperOdd(char[] arr, int i, int len) {
        int count = 1;
        int l = i - 1, r = i + 1;
        while (l >= 0 && r < len) {
            if (arr[l--] == arr[r++])
                count++;
            else
                break;

        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(3, s.countSubstrings("abc"));
        Assert.assertEquals(6, s.countSubstrings("aaa"));
        Assert.assertEquals(10, s.countSubstrings("aaaa"));
    }
}
