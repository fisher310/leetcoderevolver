package p1021;

import org.junit.Assert;

/**
 * 输入：s = "(()())(())(()(()))"
 * 输出："()()()()(())"
 */
public class Solution {

    public String removeOuterParentheses(String s) {

        StringBuilder ans = new StringBuilder();
        char[] arr = s.toCharArray();
        int a = 0, tag = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == '(') {
                a++;
            } else {
                a--;
                if (a == 0) {
                    for (int j = tag + 1; j < i; j++) {
                        ans.append(arr[j]);
                    }
                    tag = i + 1;
                }
            }

        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals("()()()()(())", s.removeOuterParentheses("(()())(())(()(()))"));
    }
}