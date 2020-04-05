package p1367;

import util.ListNode;
import util.TreeNode;

/** 二叉树中的列表 */
class Solution {

  public boolean isSubPath(ListNode head, TreeNode root) {
    if (head == null) return true;
    if (root == null) return false;
    return contains(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
  }

  boolean contains(ListNode head, TreeNode root) {
    if (head == null) return true;
    if (root == null) return false;
    if (head.val != root.val) return false;
    return contains(head.next, root.left) || contains(head.next, root.right);
  }
}
