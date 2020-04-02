package p563;

import util.TreeNode;

class Solution {
  private int ans = 0;

  public int findTilt(TreeNode root) {
    dfs(root);
    return ans;
  }

  private int dfs(TreeNode node) {
    if (node == null) return 0;
    int l = dfs(node.left);
    int r = dfs(node.right);
    ans += Math.abs(l - r);
    return l + r + node.val;
  }
}
