package p155;

import java.util.LinkedList;

/**
 * 最小栈
 */
class MinStack {

    private LinkedList<Integer> stack;

    private LinkedList<Integer> mStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        mStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (mStack.isEmpty() || mStack.peek() >= x) {
            mStack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;
        int num = stack.pop();
        if (mStack.peek() == num) {
            mStack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("the stack is empty");
        }
        return stack.peek();
    }

    public int getMin() {
        if (mStack.isEmpty()) {
            throw new IllegalStateException("the stack is empty");
        }
        return mStack.peek();
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(1);
        s.push(2);
        System.out.println(s.top());
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        System.out.println(s.top());
    }
}