package p700;

import util.TreeNode;

/** 二叉搜索树中的搜索 */
class Solution {
  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) return null;
    if (val < root.val) {
      return searchBST(root.left, val);
    } else if (val > root.val) {
      return searchBST(root.right, val);
    } else {
      return root;
    }
  }
}
