package p227;

import org.junit.Assert;

import java.util.LinkedList;

class Solution {
    public int calculate(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        char sign = '+';
        int d = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0') {
                d = d * 10 + ch - '0';
            }
            if (i == s.length() - 1 || (ch < '0' && ch != ' ')) {
                if (sign == '+') {
                    stack.push(d);
                } else if (sign == '-') {
                    stack.push(-d);
                } else {
                    int tmp = (sign == '*') ? stack.pop() * d : stack.pop() / d;
                    stack.push(tmp);
                }
                d = 0;
                sign = ch;
            }
        }

        int rs = 0;
        while (!stack.isEmpty()) {
            rs += stack.pop();
        }

        return rs;
    }

    private void process(LinkedList<Integer> nums, LinkedList<Character> operators, int n) {
        if (!operators.isEmpty()) {

            if (operators.peek() == '*') {
                nums.push(nums.pop() * n);
                operators.pop();
            } else if (operators.peek() == '/') {
                nums.push(nums.pop() / n);
                operators.pop();
            } else {
                nums.push(n);
            }
        } else {
            nums.push(n);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(1, s.calculate("2+3-4"));
        Assert.assertEquals(0, s.calculate("0"));
        Assert.assertEquals(-2147483647, s.calculate("0-2147483647"));
        Assert.assertEquals(1, s.calculate("1-1+1"));
        Assert.assertEquals(7, s.calculate("1 + 2 * 3"));
        Assert.assertEquals(1, s.calculate("1 + 2 / 3"));
        Assert.assertEquals(3, s.calculate("1 * 2 + 3 / 3"));
    }
}
