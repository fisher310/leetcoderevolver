package p669;

import util.TreeNode;

/** 修剪二叉搜索树 */
class Solution {
  public TreeNode trimBST(TreeNode root, int L, int R) {
    if (root == null) return null;
    int val = root.val;
    if (val < L) return trimBST(root.right, L, R);
    if (R < val) return trimBST(root.left, L, R);
    root.left = trimBST(root.left, L, R);
    root.right = trimBST(root.right, L, R);
    return root;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    //    TreeNode root = s.trimBST(TreeNode.createTreeNode(new Integer[] {1, 0, 2}), 1, 2);
    TreeNode root = TreeNode.createTreeNode(new Integer[] {3, 0, 4, null, 2, null, null, 1});
    root = s.trimBST(root, 1, 3);
  }
}
