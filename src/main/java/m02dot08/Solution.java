package m02dot08;

import util.ListNode;

/** 环路检测 */
class Solution {

  public ListNode detectCycle(ListNode head) {

    ListNode fast = head;
    ListNode slow = head;

    ListNode p = null;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow) {
        p = slow;
        break;
      }
    }

    if (p == null) return null;

    while (p != null && head != null) {
      if (p == head) return p;
      p = p.next;
      head = head.next;
    }

    return null;
  }

}
