package p148;

import util.ListNode;
import util.ListNodeUtil;

/** 排序链表 */
class Solution {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode fast = head.next, slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    ListNode tmp = slow.next;

    slow.next = null;
    ListNode left = sortList(head);
    ListNode right = sortList(tmp);
    ListNode dummy = new ListNode(0);
    ListNode res = dummy;
    while (left != null && right != null) {
      if (left.val < right.val) {
        res.next = left;
        left = left.next;
      } else {
        res.next = right;
        right = right.next;
      }
      res = res.next;
    }
    if (left != null) res.next = left;
    if (right != null) res.next = right;

    return dummy.next;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    ListNodeUtil.print(s.sortList(ListNodeUtil.create(new int[] {4, 1, 2, 3, 5})));
  }
}
