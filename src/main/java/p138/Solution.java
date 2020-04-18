package p138;

import java.util.HashMap;
import java.util.Map;

/** 138. 复制带随机指针的链表 */
class Solution {

  public Node copyRandomList(Node head) {
    if (head == null) return null;
    Map<Node, Integer> map = new HashMap<>();
    Map<Integer, Node> copyMap = new HashMap<>();
    Node dummy = new Node(0);
    Node curr = head;
    Node copy = dummy;
    int i = 0;
    while (curr != null) {
      copy.next = new Node(curr.val);
      map.put(curr, i);
      copyMap.put(i, copy.next);
      curr = curr.next;
      copy = copy.next;
      i++;
    }

    curr = head;
    copy = dummy.next;
    while (curr != null) {
      if (curr.random != null) {
        copy.random = copyMap.get(map.get(curr.random));
      }
      curr = curr.next;
      copy = copy.next;
    }

    return dummy.next;
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
