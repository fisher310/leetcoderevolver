package p725;

import util.ListNode;
import util.ListNodeUtil;

/** 分隔链表 */
class Solution {
  public ListNode[] splitListToParts(ListNode root, int k) {

    int N = 0;
    ListNode c = root;
    while (c != null) {
      N++;
      c = c.next;
    }

    int n = N / k, rem = N % k;

    ListNode[] ans = new ListNode[k];
    ListNode curr = root;
    for (int i = 0; i < k; i++) {
      ListNode head = curr;
      for (int j = 0; j < (i < rem ? n + 1 : n) - 1 && curr != null; j++) {
        curr = curr.next;
      }
      if (curr != null) {
        ListNode pre = curr;
        curr = curr.next;
        pre.next = null;
      }
      ans[i] = head;
    }
    return ans;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    ListNode[] listNodes = s.splitListToParts(ListNodeUtil.create(new int[] {}), 3);
    for (ListNode node : listNodes) {
      ListNodeUtil.printArray(node, true);
    }
  }
}
