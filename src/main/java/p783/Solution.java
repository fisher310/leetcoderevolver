package p783;

import util.TreeNode;

/** 二叉搜索树节点最小距离 */
class Solution {
  private int ans = Integer.MAX_VALUE;
  private Integer pre = null;

  public int minDiffInBST(TreeNode root) {
    ans = Integer.MAX_VALUE;
    pre = null;
    inorder(root);
    return ans;
  }

  private void inorder(TreeNode root) {
    if (root == null) return;
    if (root.left != null) inorder(root.left);

    if (pre == null) pre = root.val;
    else ans = Math.min(ans, Math.abs(root.val - pre));
    pre = root.val;

    if (root.right != null) inorder(root.right);
  }
}
