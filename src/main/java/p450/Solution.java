package p450;

import util.TreeNode;

class Solution {

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;
    if (key < root.val) root.left = deleteNode(root.left, key);
    else if (root.val < key) root.right = deleteNode(root.right, key);
    else {
      if (root.left == null && root.right == null) root = null;
      else if (root.right != null) {
        root.val = successor(root);
        root.right = deleteNode(root.right, root.val);
      } else {
        root.val = predessor(root);
        root.left = deleteNode(root.left, root.val);
      }
    }
    return root;
  }

  private int successor(TreeNode root) {
    root = root.right;
    while (root.left != null) root = root.left;
    return root.val;
  }

  private int predessor(TreeNode root) {
    root = root.left;
    while (root.right != null) root = root.right;
    return root.val;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
//    TreeNode root = TreeNode.createTreeNode(new Integer[] {5, 3, 6, 2, 4, null, 7});
//    TreeNode node = s.deleteNode(root, 3);
      TreeNode root = s.deleteNode(TreeNode.createTreeNode(new Integer[]{0}), 0);

  }
}
