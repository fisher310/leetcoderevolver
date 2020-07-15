package p856;

import org.junit.Assert;

import java.util.LinkedList;

class Solution {

    public int scoreOfParentheses(String S) {


        LinkedList<Integer> stack =  new LinkedList<>();


        for (int i = 0; i < S.length(); i++) {

        }

        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(6, s.scoreOfParentheses("(()(()))"));
        Assert.assertEquals(2, s.scoreOfParentheses("()()"));
        Assert.assertEquals(2, s.scoreOfParentheses("(())"));
    }
}
