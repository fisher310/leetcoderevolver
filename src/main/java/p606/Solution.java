package p606;

import util.TreeNode;

/** 根据二叉树创建字符串 */
class Solution {
  public String tree2str(TreeNode root) {
    if (root == null) return "";
    if (root.left == null && root.right == null) return root.val + "";
    if (root.right == null) return root.val + "(" + tree2str(root.left) + ")";
    return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
  }

  private String preorder(TreeNode root) {
    if (root == null) return "";
    String s = "(" + root.val;
    if (root.left == null) {
      if (root.right != null) {
        s += "()";
      }
    } else {
      s += preorder(root.left);
    }
    if (root.right != null) {
      s += preorder(root.right);
    }
    return s += ")";
  }
}
