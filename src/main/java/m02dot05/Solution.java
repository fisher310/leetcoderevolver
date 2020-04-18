package m02dot05;

import util.ListNode;
import util.ListNodeUtil;

/** 链表求和 */
class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    int rem = 0;
    while (l1 != null && l2 != null) {
      int sum = l1.val + l2.val + rem;
      rem = sum / 10;
      curr.next = new ListNode(sum % 10);
      l1 = l1.next;
      l2 = l2.next;
      curr = curr.next;
    }

    while (l1 != null) {
      int sum = l1.val + rem;
      rem = sum / 10;
      curr.next = new ListNode(sum % 10);
      curr = curr.next;
      l1 = l1.next;
    }

    while (l2 != null) {
      int sum = l2.val + rem;
      rem = sum / 10;
      curr.next = new ListNode(sum % 10);
      curr = curr.next;
      l2 = l2.next;
    }
    if (rem > 0) {
      curr.next = new ListNode(rem);
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    ListNode ans =
        s.addTwoNumbers(ListNodeUtil.create(new int[] {1, 8}), ListNodeUtil.create(new int[] {0}));
    ListNodeUtil.print(ans);
  }
}
