package p237;

import util.ListNode;

/** 删除链表中的节点 */
class Solution {
  public void deleteNode(ListNode node) {
    if (node == null) return;
    if (node.next == null) {
      node = null;
      return;
    }

    node.val = node.next.val;
    node.next = node.next.next;
  }
}
