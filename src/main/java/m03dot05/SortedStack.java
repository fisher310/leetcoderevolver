package m03dot05;

import java.util.LinkedList;

class SortedStack {
    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> tmp = new LinkedList<>();

    public SortedStack() {

    }

    public void push(int val) {
        while (!stack.isEmpty() && stack.peek() < val) {
            tmp.push(stack.pop());
        }
        stack.push(val);
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
    }

    public void pop() {
        if (!stack.isEmpty())
            stack.pop();
    }

    public int peek() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
