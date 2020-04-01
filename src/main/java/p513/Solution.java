package p513;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int findBottomLeftValue(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    TreeNode last = null;
    while (!queue.isEmpty()) {
      last = queue.poll();
      if (last.right != null) {
        queue.offer(last.right);
      }
      if (last.left != null) {
        queue.offer(last.left);
      }
    }
    return last.val;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int ans = s.findBottomLeftValue(TreeNode.createTreeNode(new Integer[] {2, 1, 3}));
    System.out.println(ans);
    ans =
        s.findBottomLeftValue(
            TreeNode.createTreeNode(new Integer[] {1, 2, 3, 4, 5, 6, null, null, 7}));
    System.out.println(ans);
  }
}
