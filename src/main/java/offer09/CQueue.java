package offer09;

import java.util.LinkedList;

class CQueue {
    LinkedList<Integer> offerStack;
    LinkedList<Integer> pullStack;

    public CQueue() {
        offerStack = new LinkedList<>();
        pullStack = new LinkedList<>();
    }

    public void appendTail(int value) {
        offerStack.push(value);
    }

    public int deleteHead() {
        if (!pullStack.isEmpty()) {
            return pullStack.pop();
        }

        while (!offerStack.isEmpty()) {
            pullStack.push(offerStack.pop());
        }

        if (pullStack.isEmpty()) {
            return -1;
        }
        return pullStack.pop();
    }
}
