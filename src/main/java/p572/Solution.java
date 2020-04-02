package p572;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public boolean isSubtree(TreeNode s, TreeNode t) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(s);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (validSubtree(node, t)) {
        return true;
      }
      if (node.left != null) queue.offer(node.left);
      if (node.right != null) queue.offer(node.right);
    }
    return false;
  }

  boolean validSubtree(TreeNode s, TreeNode t) {
    if (s == null) return t == null;
    if (t == null) return false;
    if (s.val == t.val) {
      return validSubtree(s.left, t.left) && validSubtree(s.right, t.right);
    }
    return false;
  }
}
