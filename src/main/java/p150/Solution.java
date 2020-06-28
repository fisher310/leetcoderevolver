package p150;

import java.util.LinkedList;

/** 逆波兰表达式 */
class Solution {

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        int operator1, operator2;
        for (String t : tokens) {
            switch (t) {
                case "+":
                    operator1 = stack.pop();
                    operator2 = stack.pop();
                    stack.push(operator1 + operator2);
                    break;
                case "-":
                    operator1 = stack.pop();
                    operator2 = stack.pop();
                    stack.push(operator2 - operator1);
                    break;
                case "*":
                    operator1 = stack.pop();
                    operator2 = stack.pop();
                    stack.push(operator1 * operator2);
                    break;
                case "/":
                    operator1 = stack.pop();
                    operator2 = stack.pop();
                    stack.push(operator2 / operator1);
                    break;
                default:
                    stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}
