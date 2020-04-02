package p530;

import util.TreeNode;

class Solution {
  private int min = Integer.MAX_VALUE;
  private Integer pre;

  public int getMinimumDifference(TreeNode root) {
    inorder(root);
    return min;
  }

  void inorder(TreeNode root) {
    if (root == null) return;
    inorder(root.left);
    if (pre != null) {
      int abs = Math.abs(pre - root.val);
      if (abs < min) {
        min = abs;
      }
    }
    pre = root.val;
    inorder(root.right);
  }
}
