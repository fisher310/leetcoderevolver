package p445;

import util.ListNode;
import util.ListNodeUtil;

import java.util.LinkedList;

/** 两数相加 II */
class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    LinkedList<Integer> s1 = new LinkedList<>();
    LinkedList<Integer> s2 = new LinkedList<>();

    while (l1 != null) {
      s1.push(l1.val);
      l1 = l1.next;
    }

    while (l2 != null) {
      s2.push(l2.val);
      l2 = l2.next;
    }

    ListNode head = null;
    int rem = 0;
    int sum = 0;
    while (!s1.isEmpty() && !s2.isEmpty()) {
      int p1 = s1.pop();
      int p2 = s2.pop();
      sum = p1 + p2 + rem;
      rem = sum / 10;
      ListNode n = new ListNode(sum % 10);
      n.next = head;
      head = n;
    }
    while (!s1.isEmpty()) {
      int p1 = s1.pop();
      sum = p1 + rem;
      rem = sum / 10;
      ListNode n = new ListNode(sum % 10);
      n.next = head;
      head = n;
    }
    while (!s2.isEmpty()) {
      int p2 = s2.pop();
      sum = p2 + rem;
      rem = sum / 10;
      ListNode n = new ListNode(sum % 10);
      n.next = head;
      head = n;
    }
    if (rem > 0) {
      ListNode n = new ListNode(rem);
      n.next = head;
      head = n;
    }
    return head;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    ListNode head =
        s.addTwoNumbers(
            ListNodeUtil.create(new int[] {7, 2, 4, 3}), ListNodeUtil.create(new int[] {5, 6, 4}));
    ListNodeUtil.print(head);
  }
}
