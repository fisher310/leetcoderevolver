package p1171;

import util.ListNode;
import util.ListNodeUtil;

import java.util.ArrayList;
import java.util.List;

/** 1171. 从链表中删去总和值为零的连续节点 */
class Solution {

  public ListNode removeZeroSumSublists(ListNode head) {
    if (head == null) return null;
    List<ListNode> list = new ArrayList<>();
    ListNode curr = head;
    while (curr != null) {
      list.add(curr);
      curr = curr.next;
    }

    int l = 0;
    int r = 0;
    outer:
    for (int i = 0; i < list.size(); ) {
      int sum = 0;
      for (int j = i; j < list.size(); j++) {
        sum += list.get(j).val;
        if (sum == 0) {
          for (int a = j - i; a >= 0; a--) {
            list.remove(a + i);
          }
          i = Math.max(i - 1, 0);
          continue outer;
        }
      }
      i++;
    }

    if (list.size() == 0) return null;
    ListNode ans = list.get(0);

    for (int i = 1; i < list.size(); i++) {
      list.get(i - 1).next = list.get(i);
    }
    list.get(list.size() - 1).next = null;

    return ans;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    //    ListNode ans = s.removeZeroSumSublists(ListNodeUtil.create(new int[] {1, 2, 3, -3, 4}));
    ListNode ans = s.removeZeroSumSublists(ListNodeUtil.create(new int[] {1, 2, 3, -3, -2}));
    ListNodeUtil.print(ans);
  }
}
