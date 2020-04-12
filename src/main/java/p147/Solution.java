package p147;

import util.ListNode;
import util.ListNodeUtil;

/** 对链表进行插入排序 */
class Solution {
  public ListNode insertionSortList(ListNode head) {
    if (head == null) return null;

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = head;
    ListNode curr = head.next;
    ListNode next = null;
    while (curr != null) {
      next = curr.next;
      if (curr.val < pre.val) {
        pre.next = next;
        ListNode need = curr;
        curr = next;

        ListNode pp = dummy;
        ListNode p1 = dummy.next;
        while (p1.val < need.val) {
          pp = p1;
          p1 = p1.next;
        }
        pp.next = need;
        need.next = p1;
      } else {
        pre = curr;
        curr = next;
      }
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    ListNodeUtil.print(s.insertionSortList(ListNodeUtil.create(new int[] {4, 2, 1, 3})));
    ListNodeUtil.print(s.insertionSortList(ListNodeUtil.create(new int[] {-1, 5, 3, 4, 0})));
    ListNodeUtil.print(s.insertionSortList(ListNodeUtil.create(new int[] {-1, 5, 3, 5, -1})));
    ListNodeUtil.print(s.insertionSortList(ListNodeUtil.create(new int[] {0, 0})));
    ListNodeUtil.print(s.insertionSortList(ListNodeUtil.create(new int[] {0})));
    ListNodeUtil.print(s.insertionSortList(null));
  }
}
