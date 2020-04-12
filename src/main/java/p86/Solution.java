package p86;

import util.ListNode;
import util.ListNodeUtil;

/** 分隔链表 */
class Solution {
  public ListNode partition(ListNode head, int x) {

    ListNode dummy1 = new ListNode(0);
    ListNode dummy2 = new ListNode(0);

    ListNode current1 = dummy1;
    ListNode current2 = dummy2;
    while (head != null) {
      if (head.val < x) {
        current1.next = new ListNode(head.val);
        current1 = current1.next;
      } else {
        current2.next = new ListNode(head.val);
        current2 = current2.next;
      }
      head = head.next;
    }

    current1.next = dummy2.next;
    return dummy1.next;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    ListNode head = s.partition(ListNodeUtil.create(new int[] {1, 4, 3, 2, 5, 2}), 3);
    ListNodeUtil.print(head);
  }
}
