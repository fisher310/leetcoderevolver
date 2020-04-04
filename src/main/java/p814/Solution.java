package p814;

import util.TreeNode;

/** 二叉树剪枝 */
class Solution {
  public TreeNode pruneTree(TreeNode root) {
    postorder(root);
    return root;
  }

  private boolean postorder(TreeNode root) {
    if (root == null) return true;
    boolean left = postorder(root.left);
    if (left) root.left = null;
    boolean right = postorder(root.right);
    if (right) root.right = null;
    return root.val == 0 && left && right;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode root = s.pruneTree(TreeNode.createTreeNode(new Integer[] {1, null, 0, 0, 1}));
    root = s.pruneTree(TreeNode.createTreeNode(new Integer[]{1,0,1,0,0,0,1}));
  }
}
