package p24;

import util.ListNode;
import util.ListNodeUtil;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * <p>You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * <p>Example:
 *
 * <p>Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class Solution {
  public ListNode swapPairs(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return head;
    }
    ListNode tmp = head.next.next;
    ListNode newHead = head.next;
    newHead.next = head;
    head.next = swapPairs(tmp);
    return newHead;
  }

  public static void main(String[] args) {
    ListNode listNode = ListNodeUtil.create(new int[] {1, 2, 3, 4, 5});
    Solution s = new Solution();
    ListNode newHead = s.swapPairs(listNode);
    ListNodeUtil.print(newHead);
  }
}
