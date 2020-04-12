package p83;

import util.ListNode;
import util.ListNodeUtil;

/** 删除排序链表中的重复元素 */
class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) return null;

    ListNode pre = head;
    ListNode curr = head.next;
    while (curr != null) {
      if (curr.val == pre.val) {
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
    ListNode head = s.deleteDuplicates(ListNodeUtil.create(new int[] {1, 1, 2}));
    ListNodeUtil.print(head);
    ListNodeUtil.print(s.deleteDuplicates(ListNodeUtil.create(new int[] {1, 1, 2, 3, 3})));
  }
}
