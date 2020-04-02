package p653;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/** 两数之和 IV - 输入BST */
class Solution {
  public boolean findTarget(TreeNode root, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    return dfs(root, k, map);
  }

  boolean dfs(TreeNode root, int k, Map<Integer, Integer> map) {
    if (root == null) return false;
    int v = k - root.val;
    if (map.containsKey(v)) {
      return true;
    }
    map.put(root.val, 1);
    return dfs(root.left, k, map) || dfs(root.right, k, map);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    boolean ans = s.findTarget(TreeNode.createTreeNode(new Integer[] {5, 3, 6, 2, 4, null, 7}), 9);
    System.out.println(ans);
  }
}
