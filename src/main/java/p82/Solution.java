package p82;

import util.ListNode;
import util.ListNodeUtil;

/** 删除排序链表中的重复元素 II */
class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) return null;
//    ListNode dummy = new ListNode(0);
//    dummy.next = head;

    boolean f = false;
    do {
      f = false;
      while (head.next != null && head.next.val == head.val) {
        f = true;
        head = head.next;
      }
      if (f) {
        head = head.next;
      }

    } while (f && head != null);

    if (head == null) return null;

    ListNode pre = head;
    ListNode curr = head.next;

    while (curr != null) {
      boolean f1 = false;
      while (curr.next != null && curr.next.val == curr.val) {
        f1 = true;
        curr = curr.next;
      }
      if (f1) {
        pre.next = curr.next;
      } else {
        pre = curr;
      }
      curr = curr.next;
    }

    return head;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    ListNodeUtil.print(s.deleteDuplicates(ListNodeUtil.create(new int[] {1, 1, 2, 2})));
    ListNode head = s.deleteDuplicates(ListNodeUtil.create(new int[] {1, 2, 3, 3, 4, 4, 5}));
    ListNodeUtil.print(head);

    ListNodeUtil.print(s.deleteDuplicates(ListNodeUtil.create(new int[] {1, 1, 1, 2, 3})));
  }
}
