package p22;

import java.util.*;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(n, n, "", result);
        return result;
    }

    void helper(int left, int right, String s, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        if (left > 0) {
            helper(left - 1, right, "(" + s, result);
        }
        if (right > left) {
            helper(left, right - 1, s + ")", result);
        }
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.generateParenthesis(3));
    }
}