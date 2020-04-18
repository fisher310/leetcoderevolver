package m02dot02;

import util.ListNode;

/**
 * 返回倒数第 k 个节点
 */
class Solution {
  public int kthToLast(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode fast = dummy;
    ListNode slow = dummy;

    for (int i = 0; i < k; i++) {
      fast = fast.next;
      if (fast == null) return -1;
    }

    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }

    return slow.val;
  }
}
