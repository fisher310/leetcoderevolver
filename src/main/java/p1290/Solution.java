package p1290;

import util.ListNode;
import util.ListNodeUtil;

/** 二进制链表转整数 */
class Solution {
  public int getDecimalValue(ListNode head) {

    ListNode pre = null, curr = head, next = null;
    while (curr != null) {
      next = curr.next;
      curr.next = pre;
      pre = curr;
      curr = next;
    }

    int ans = 0;
    int i = 0;
    curr = pre;
    while (curr != null) {
      ans += curr.val * (1 << i);
      curr = curr.next;
      i++;
    }

    return ans;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int ans = s.getDecimalValue(ListNodeUtil.create(new int[] {1, 0, 1}));
    System.out.println(ans);
  }
}
