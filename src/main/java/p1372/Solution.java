package p1372;

import util.TreeNode;

/** 二叉树中最长交错路径 */
class Solution {
  int max = 0;

  public int longestZigZag(TreeNode root) {
    if (root == null) return 0;
//    max = 0;
    dfs(root.left, true, 1);
    dfs(root.right, false, 1);
    return max;
  }

  void dfs(TreeNode node, boolean left, int level) {
    if (node == null) return;
    max = Math.max(max, level);
    if (left) {
      dfs(node.right, false, level + 1);
      dfs(node.left, true, 1);
    } else {
      dfs(node.right, false, 1);
      dfs(node.left, true, level + 1);
    }
  }
}
