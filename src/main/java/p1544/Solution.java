package p1544;

import org.junit.Assert;

import java.util.Deque;
import java.util.LinkedList;

class Solution {

    public String makeGood(String s) {

        Deque<Character> deque = new LinkedList<>();

        char[] ch = s.toCharArray();

        for (char c : ch) {
            if (!deque.isEmpty()) {
                char last = deque.peekLast();
                if (last != c && Math.abs(last - c) == 32) {
                    deque.pollLast();
                    continue;
                }
            }
            deque.offerLast(c);
        }

        if (deque.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals("leetcode", s.makeGood("leEeetcode"));
        Assert.assertEquals("", s.makeGood("abBAcC"));
        Assert.assertEquals("s", s.makeGood("s"));
    }
}
