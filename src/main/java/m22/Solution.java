package m22;

import util.ListNode;
import util.ListNodeUtil;

/** 链表中倒数第k个节点 */
class Solution {

  public ListNode getKthFromEnd(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode fast = dummy;
    ListNode slow = dummy;

    for (int i = 0; i < k; i++) {
      fast = fast.next;
      if (fast == null) return null;
    }

    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }

    return slow;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    ListNode res = s.getKthFromEnd(ListNodeUtil.create(new int[] {1, 2, 3, 4, 5}), 2);

    ListNodeUtil.print(res);
  }
}
