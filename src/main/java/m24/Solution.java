package m24;

import util.ListNode;

/** 反转链表 */
class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode pre = null, curr = head, next = null;

    while (curr != null) {
      next = curr.next;
      curr.next = pre;
      pre = curr;
      curr = next;
    }

    return pre;
  }
}
