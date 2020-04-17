package p143;

import util.ListNode;
import util.ListNodeUtil;

import java.util.LinkedList;

/** 重排链表 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. */
class Solution {
  public void reorderList(ListNode head) {
    if (head == null) return;

    LinkedList<ListNode> stack = new LinkedList<>();
    ListNode curr = head;
    int size = 0;
    while (curr != null) {
      stack.push(curr);
      curr = curr.next;
      size++;
    }

    boolean odd = size % 2 == 1;

    ListNode h = head;
    ListNode t;
    while (true) {
      ListNode next = h.next;
      t = stack.pop();
      if (odd && h == t) {
        t.next = null;
        break;
      } else if (!odd && h.next == t) {
        t.next = null;
        break;
      }
      h.next = t;
      t.next = next;
      h = next;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    ListNode head = ListNodeUtil.create(new int[] {1, 2, 3, 4, 5});
    s.reorderList(head);
    ListNodeUtil.print(head);
  }
}
