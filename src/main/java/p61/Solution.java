package p61;

import util.ListNode;
import util.ListNodeUtil;

/** 旋转链表 */
class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) return head;

    ListNode c = head;
    int N = 0;
    while (c != null) {
      N++;
      c = c.next;
    }

    k = k % N;
    if (k == 0) return head;

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode curr = dummy;
    while (k >= 0) {
      curr = curr.next;
      k--;
    }

    ListNode p1 = dummy;
    ListNode pre = curr;
    while (curr != null) {
      pre = curr;
      curr = curr.next;
      p1 = p1.next;
    }

    if (p1.next != null) {
      pre.next = dummy.next;
      dummy.next = p1.next;
      p1.next = null;
    }
    return dummy.next;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
        ListNode head = s.rotateRight(ListNodeUtil.create(new int[]{1,2,3,4,5}), 2);
//    ListNode head = s.rotateRight(ListNodeUtil.create(new int[] {0, 1, 2}), 4);
    ListNodeUtil.print(head);
  }
}
