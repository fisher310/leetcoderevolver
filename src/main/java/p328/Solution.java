package p328;

import util.ListNode;
import util.ListNodeUtil;

/** 奇偶链表 */
class Solution {
  public ListNode oddEvenList(ListNode head) {
    ListNode oddDummy = new ListNode(0);
    ListNode evenDummy = new ListNode(0);
    ListNode curOdd = oddDummy;
    ListNode curEven = evenDummy;

    int i = 1;
    while (head != null) {
      if (i++ % 2 == 1) {
        curOdd.next = head;
        curOdd = curOdd.next;
      } else {
        curEven.next = head;
        curEven = curEven.next;
      }
      head = head.next;
    }
    curEven.next = null;
    curOdd.next = evenDummy.next;

    return oddDummy.next;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    ListNode head = s.oddEvenList(ListNodeUtil.create(new int[] {1, 2, 3, 4, 5}));
    ListNodeUtil.print(head);

    ListNodeUtil.print(s.oddEvenList(ListNodeUtil.create(new int[] {2, 1, 3, 5, 6, 4, 7})));
  }
}
