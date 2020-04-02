package p543;

import util.TreeNode;

/** 二叉树的直径 */
class Solution {

  private int ans = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    dfs(root);
    return ans;
  }

  private int dfs(TreeNode node) {
    if (node == null) return 0;
    int l = dfs(node.left);
    int r = dfs(node.right);
    ans = Math.max(ans, l + r);

    return Math.max(l, r) + 1;
  }
}
