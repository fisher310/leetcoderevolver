package p227;

import org.junit.Assert;

import java.util.LinkedList;

class Solution {
    public int calculate(String s) {
        LinkedList<Integer> nums = new LinkedList<>();
        LinkedList<Character> operators = new LinkedList<>();

        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c == '*' || c == '/' || c == '+' || c == '-') {
                int n1 = Integer.parseInt(s.substring(start, i).trim());
                start = i + 1;
                process(nums, operators, n1);
                operators.push(c);
            }
        }

        int n = Integer.parseInt(s.substring(start, s.length()).trim());
        process(nums, operators, n);
        while (!operators.isEmpty()) {
            char c = operators.pollLast();
            int n1 = nums.pollLast();
            int n2 = nums.pollLast();
            switch (c) {
                case '+':
                    nums.offerLast(n1 + n2);
                    break;
                case '-':
                    nums.offerLast(n1 - n2);
                    break;
            }
        }
        return nums.pop();
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
