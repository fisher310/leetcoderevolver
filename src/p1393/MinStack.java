package p1393;


public class MinStack {

  //  private Deque<Integer> deque;
  //
  //  private LinkedList<Integer> stack;
  //  /** initialize your data structure here. */
  //  public MinStack() {
  //    deque = new LinkedList<>();
  //    stack = new LinkedList<>();
  //  }
  //
  //  public void push(int x) {
  //    if (deque.isEmpty() || deque.getLast() >= x) {
  //      deque.offerLast(x);
  //    }
  //    stack.offerFirst(x);
  //  }
  //
  //  public void pop() {
  //    if (stack.isEmpty()) {
  //      throw new IllegalStateException("the stack is empty");
  //    }
  //    int ans = stack.removeFirst();
  //    if (ans == deque.getLast()) {
  //      deque.pollLast();
  //    }
  //  }
  //
  //  public int top() {
  //    if (stack.isEmpty()) {
  //      throw new IllegalStateException("the stack is empty");
  //    }
  //    return stack.peekFirst();
  //  }
  //
  //  public int getMin() {
  //    if (deque.isEmpty()) {
  //      throw new IllegalStateException("the stack is empty");
  //    }
  //    return deque.getLast();
  //  }

  /** initialize your data structure here. */
  class Node {
    int val;
    int min;
    Node next;

    Node(int val, int min, Node next) {
      this.val = val;
      this.min = min;
      this.next = next;
    }
  }

  Node head;

  public MinStack() {
    head = null;
  }

  public void push(int x) {
    if (head == null) {
      head = new Node(x, x, null);
      return;
    }
    head = new Node(x, Math.min(x, head.min), head);
  }

  public void pop() {
    head = head.next;
  }

  public int top() {
    return head.val;
  }

  public int getMin() {
    return head.min;
  }

  /**
   * Your MinStack object will be instantiated and called as such: MinStack obj = new MinStack();
   * obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4 = obj.getMin();
   */
  public static void main(String[] args) {
    MinStack obj = new MinStack();
    obj.push(-2);
    obj.push(0);
    obj.push(-3);
    obj.getMin();
    obj.pop();
    obj.top();
    obj.getMin();
  }
}
