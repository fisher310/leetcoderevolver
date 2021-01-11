package p844;

import org.junit.Assert;

import java.util.LinkedList;

class Solution {

    public boolean backspaceCompare(String S, String T) {
        return process(S).equals(process(T));
    }

    private String process(String s) {
        char[] ch = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();

        for (char c : ch) {
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertTrue(s.backspaceCompare("ab#c", "ad#c"));
    }
}
