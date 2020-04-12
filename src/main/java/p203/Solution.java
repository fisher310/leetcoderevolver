package p203;

import util.ListNode;
import util.ListNodeUtil;

/** 移除链表元素 */
class Solution {
  public ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode pre = dummy;
    ListNode curr = head;
    while (curr != null) {
      if (curr.val == val) {
        pre.next = curr.next;
      } else {
        pre = curr;
      }
      curr = curr.next;
    }
    return dummy.next;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    ListNode head = s.removeElements(ListNodeUtil.create(new int[] {1, 2, 6, 3, 4, 5, 6}), 6);
    ListNodeUtil.print(head);

    ListNodeUtil.print(s.removeElements(ListNodeUtil.create(new int[]{1,1}),1));
  }
}
