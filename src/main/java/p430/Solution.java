package p430;

import java.util.LinkedList;

/** 扁平化多级双向链表 */
class Solution {
  public Node flatten(Node head) {
    if (head == null) return null;
    Node dummy = new Node();
    LinkedList<Node> stack = new LinkedList<>();
    stack.push(head);
    Node pre = dummy;
    while (!stack.isEmpty()) {
      Node node = stack.pop();
      pre.next = node;
      node.prev = pre;
      while (node != null) {
        if (node.child != null) {
          if (node.next != null) stack.push(node.next);
          node.next = node.child;
          node.child.prev = node;
          node.child = null;
        }
        pre = node;
        node = node.next;
      }
    }

    dummy.next.prev = null;
    return dummy.next;
  }
}

class Node {
  public int val;
  public Node prev;
  public Node next;
  public Node child;
};
