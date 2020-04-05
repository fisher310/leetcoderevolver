package p1367;

import util.ListNode;
import util.TreeNode;

/** 二叉树中的列表 */
class Solution {

  public boolean isSubPath(ListNode head, TreeNode root) {
    StringBuilder s1 = new StringBuilder();
    while (head != null) {
      s1.append(head.val).append("#");
      head = head.next;
    }

    return dfs(root, s1.toString(), "");
  }

  boolean dfs(TreeNode root, String s1, String s2) {
    if (root == null) {
      return s2.contains(s1);
    }
    String s = s2 + root.val + "#";
    if (s.contains(s1)) return true;
    return dfs(root.left, s1, s) || dfs(root.right, s1, s);
  }
}
