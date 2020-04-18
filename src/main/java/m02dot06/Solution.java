package m02dot06;

import util.ListNode;
import util.ListNodeUtil;

import java.util.ArrayList;
import java.util.List;

/** 回文链表 */
class Solution {
  public boolean isPalindrome(ListNode head) {
    if (head == null) return true;
    List<Integer> list = new ArrayList<>();
    ListNode curr = head;
    while (curr != null) {
      list.add(curr.val);
      curr = curr.next;
    }
    int l = 0;
    int r = list.size() - 1;
    while (l < r) {
      if (!list.get(l++).equals(list.get(r--))) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    boolean ans = s.isPalindrome(ListNodeUtil.create(new int[] {-129, -129}));
    System.out.println(ans);
  }
}
