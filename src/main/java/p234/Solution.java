package p234;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;

/** 回文链表 */
class Solution {
  public boolean isPalindrome(ListNode head) {
    if (head == null) return true;
    List<Integer> list = new ArrayList<>();
    while (head != null) {
      list.add(head.val);
      head = head.next;
    }
    for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
      if (!list.get(i).equals(list.get(j))) {
        return false;
      }
    }

    return true;
  }
}
