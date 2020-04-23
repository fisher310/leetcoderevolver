package p784;

import java.util.LinkedList;
import java.util.List;

/** 字母大小写全排列 */
public class Solution {

    private List<String> ans;

    public List<String> letterCasePermutation(String S) {
        ans = new LinkedList<>();
        ans.add(S);
        dfs(S.toCharArray(), 0);
        return ans;
    }

    void dfs(char[] chars, int start) {
        for (int i = start; i < chars.length; i++) {
            if (isLowerCase(chars[i])) {
                chars[i] -= 32;
                ans.add(new String(chars));
                dfs(chars, i + 1);
                chars[i] += 32;
            } else if (isUpperCase(chars[i])) {
                chars[i] += 32;
                ans.add(new String(chars));
                dfs(chars, i + 1);
                chars[i] -= 32;
            }
        }
    }

    boolean isUpperCase(char c) {
        return 'A' <= c && c <= 'Z';
    }

    boolean isLowerCase(char c) {
        return 'a' <= c && c <= 'z';
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> ans = s.letterCasePermutation("a1b2");
        System.out.println(ans);
        System.out.println(s.letterCasePermutation("3z4"));
        System.out.println(s.letterCasePermutation("12345"));
        System.out.println(s.letterCasePermutation("C"));
        System.out.println(s.letterCasePermutation("aC"));
    }
}
