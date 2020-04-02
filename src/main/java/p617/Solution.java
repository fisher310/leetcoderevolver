package p617;

import util.TreeNode;

/** 合并二叉树 */
class Solution {
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return null;
    if (t1 == null) return t2;
    if (t2 == null) return t1;
    t1.val += t2.val;
    t1.left = mergeTrees(t1.left, t2.left);
    t1.right = mergeTrees(t1.right, t2.right);
    return t1;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode root = s.mergeTrees(
            TreeNode.createTreeNode(new Integer[]{1, 3, 2, 5}),
            TreeNode.createTreeNode(new Integer[]{2, 1, 3, null, 4, null, 7}));
  }
}
