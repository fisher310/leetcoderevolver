package p232;

import java.util.LinkedList;

public class MyQueue {
  /** Initialize your data structure here. */
  private LinkedList<Integer> input;

  private LinkedList<Integer> output;

  public MyQueue() {

    input = new LinkedList<>();
    output = new LinkedList<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    input.addFirst(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    if (output.isEmpty()) {
      while (!input.isEmpty()) {
        output.addFirst(input.removeFirst());
      }
    }
    return output.removeFirst();
  }

  /** Get the front element. */
  public int peek() {
    if (output.isEmpty()) {
      while (!input.isEmpty()) {
        output.addFirst(input.removeFirst());
      }
    }
    return output.getFirst();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return input.isEmpty() && output.isEmpty();
  }

  /**
   * Your MyQueue object will be instantiated and called as such: MyQueue obj = new MyQueue();
   * obj.push(x); int param_2 = obj.pop(); int param_3 = obj.peek(); boolean param_4 = obj.empty();
   */
}
