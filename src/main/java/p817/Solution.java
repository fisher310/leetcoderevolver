package p817;

import util.ListNode;
import util.ListNodeUtil;

import java.util.HashMap;
import java.util.Map;

/** */
class Solution {
  public int numComponents(ListNode head, int[] G) {
    Map<Integer, Integer> map = new HashMap<>(G.length);
    for (int value : G) {
      map.put(value, map.getOrDefault(value, 0) + 1);
    }

    int ans = 0;
    ListNode curr = head;
    // 至少有一个元素的话是组件
    boolean component = false;
    while (curr != null) {
      int remind = map.getOrDefault(curr.val, 0);
      if (remind > 0) {
        component = true;
        map.put(curr.val, remind - 1);
      } else if (component) {
        ans++;
        component = false;
      }
      curr = curr.next;
    }
    if (component) {
      ans++;
    }

    return ans;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
//    int ans =
//        s.numComponents(ListNodeUtil.create(new int[] {0, 1, 2, 3, 4}), new int[] {0, 3, 1, 4});
      int ans = s.numComponents(ListNodeUtil.create(new int[]{0,1,2,3}), new int[]{0,1,3});
    System.out.println(ans);
  }
}
