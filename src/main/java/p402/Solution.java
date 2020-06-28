package p402;

import java.util.LinkedList;

/**
 * 移除K个数字
 */
class Solution {
    public String removeKdigits(String num, int k) {

        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && k > 0) {
                if (stack.peek() > c) {
                    stack.pop();
                    k--;
                } else {
                    break;
                }
            }
            if (!stack.isEmpty() || c != '0') {
                stack.push(c);
            }
        }

        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pollLast());
        }

        return ans.length() > 0 ? ans.toString() : "0";
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeKdigits("10", 2));
        System.out.println(s.removeKdigits("9", 1));
        System.out.println(s.removeKdigits("1432219", 3));
        System.out.println(s.removeKdigits("10200", 1));
    }
}
