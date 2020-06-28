package p316;

import java.util.LinkedList;

/** 去除重复字母 */
class Solution {

    public String removeDuplicateLetters(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.contains(c)) {
                continue;
            } else if (stack.isEmpty()) {
                stack.push(c);
            } else {
                while (!stack.isEmpty()) {
                    char top = stack.peek();
                    if (s.lastIndexOf(top) > i && top > c) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
                stack.push(c);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pollLast());
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeDuplicateLetters("baa"));
        System.out.println(s.removeDuplicateLetters("bcabc"));
        System.out.println(s.removeDuplicateLetters("cbacdcbc"));
    }
}
