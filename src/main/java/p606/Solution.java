package p606;

import util.TreeNode;

/** 根据二叉树创建字符串 */
class Solution {
  public String tree2str(TreeNode root) {
    String ans = preorder(root);
    if (ans.length() > 2) {
      ans = ans.substring(1, ans.length() - 1);
    }
    return ans;
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
