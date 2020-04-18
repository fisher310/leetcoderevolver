package m18;

import util.ListNode;

/** 删除链表的节点 */
class Solution {

  public ListNode deleteNode(ListNode head, int val) {
    if (head == null) return null;

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode pre = dummy;
    ListNode curr = head;
    while (curr != null) {
      if (curr.val == val) {
        pre.next = curr.next;
        break;
      }
      pre = curr;
      curr = curr.next;
    }

    return dummy.next;
  }
}
