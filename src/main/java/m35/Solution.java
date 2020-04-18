package m35;

import java.util.HashMap;
import java.util.Map;

/** 复杂链表的复制 */
class Solution {

  Map<Node, Node> visited = new HashMap<>();

  public Node copyRandomList(Node head) {

    if (head == null) return null;

    Node oldNode = head;
    Node newNode = new Node(oldNode.val);
    this.visited.put(oldNode, newNode);

    while (oldNode != null) {
      newNode.random = this.getClonedNode(oldNode.random);
      newNode.next = this.getClonedNode(oldNode.next);

      oldNode = oldNode.next;
      newNode = newNode.next;
    }

    return visited.get(head);
  }

  private Node getClonedNode(Node node) {
    if (node != null) {
      if (this.visited.containsKey(node)) {
        return this.visited.get(node);
      } else {
        Node n = new Node(node.val);
        this.visited.put(node, n);
        return n;
      }
    }
    return null;
  }

  private class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }
}
