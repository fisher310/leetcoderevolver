package p701;

import util.TreeNode;

/** 二叉搜索树中的插入操作 */
class Solution {
  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) return new TreeNode(val);
    if (val < root.val) root.left = insertIntoBST(root.left, val);
    else if (val > root.val) root.right = insertIntoBST(root.right, val);
    return root;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode root = s.insertIntoBST(TreeNode.createTreeNode(new Integer[] {4, 2, 7, 1, 3}), 5);
  }
}
