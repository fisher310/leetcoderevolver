package m02dot01;

import util.ListNode;
import util.ListNodeUtil;

import java.util.HashSet;
import java.util.Set;

/** 移除重复节点 */
class Solution {
  public ListNode removeDuplicateNodes(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode curr = dummy.next;

    Set<Integer> set = new HashSet<>();
    while (curr != null) {
      if (set.contains(curr.val)) {
        pre.next = curr.next;
      } else {
        pre = curr;
        set.add(curr.val);
      }
      curr = curr.next;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    ListNode head = s.removeDuplicateNodes(ListNodeUtil.create(new int[] {1, 2, 3, 3, 2, 1}));
    ListNodeUtil.print(head);
  }
}
