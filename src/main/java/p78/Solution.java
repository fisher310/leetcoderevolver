package p78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** 子集 */
class Solution {
  List<List<Integer>> ans;

  public List<List<Integer>> subsets(int[] nums) {
    ans = new LinkedList<>();
    ans.add(new ArrayList<>());
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 1; i <= nums.length; i++) {
      dfs(0, nums, i, list);
    }
    return ans;
  }

  void dfs(int cur, int[] nums, int k, LinkedList<Integer> list) {
    if (k == list.size()) {
      ans.add(new ArrayList<>(list));
      return;
    }

    for (int i = cur; i < nums.length; i++) {
      list.addLast(nums[i]);
      dfs(i + 1, nums, k, list);
      list.removeLast();
      //      list.remove(list.size() - 1);
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    List<List<Integer>> ans = s.subsets(new int[] {1, 2, 3});
    System.out.println(ans);
  }
}
