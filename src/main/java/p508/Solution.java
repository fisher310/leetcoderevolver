package p508;

import util.TreeNode;

import java.util.*;

class Solution {

  Map<Integer, Integer> map = new HashMap<>();

  public int[] findFrequentTreeSum(TreeNode root) {
    postOrder(root);
    List<Integer> ans = new ArrayList<>();
    int max = 0;
    for (Map.Entry<Integer, Integer> en : map.entrySet()) {

      if (en.getValue() > max) {
        ans.clear();
        ans.add(en.getKey());
        max = en.getValue();
      } else if (en.getValue() == max) {
        ans.add(en.getKey());
      }
    }

    int[] res = new int[ans.size()];
    for (int i = 0, n = ans.size(); i < n; i++) {
      res[i] = ans.get(i);
    }
    return res;
  }

  int postOrder(TreeNode root) {

    if (root == null) return 0;
    int l = postOrder(root.left);
    int r = postOrder(root.right);

    int sum = l + r + root.val;
    map.put(sum, map.getOrDefault(sum, 0) + 1);
    return sum;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] ans = s.findFrequentTreeSum(TreeNode.createTreeNode(new Integer[] {5, 2, -3}));
    System.out.println(Arrays.toString(ans));
    ans = new Solution().findFrequentTreeSum(TreeNode.createTreeNode(new Integer[]{5,2,-5}));
    System.out.println(Arrays.toString(ans));
  }
}
