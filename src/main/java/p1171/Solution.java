package p1171;

import util.ListNode;
import util.ListNodeUtil;

import java.util.HashMap;
import java.util.Map;

/** 1171. 从链表中删去总和值为零的连续节点 */
class Solution {

  public ListNode removeZeroSumSublists(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    Map<Integer, ListNode> map = new HashMap<>();
    ListNode curr = dummy.next;
    int sum = 0;
    for (ListNode d = dummy; d != null; d = d.next) {
      sum += d.val;
      map.put(sum, d);
    }

    sum = 0;
    for (ListNode node = dummy; node != null; node = node.next) {
      sum += node.val;
      node.next = map.get(sum).next;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    //    ListNode ans = s.removeZeroSumSublists(ListNodeUtil.create(new int[] {1, 2, 3, -3, 4}));
    ListNode ans = s.removeZeroSumSublists(ListNodeUtil.create(new int[] {1, 2, 3, -3, -2}));
    ListNodeUtil.print(ans);
  }
}
