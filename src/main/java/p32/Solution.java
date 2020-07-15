package p32;

import java.util.LinkedList;

class Solution {

    public int longestValidParentheses(String s) {

        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }

        return ans;
    }
}
