package p404;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) return 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int ans = 0;
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node.left != null) {
        if (node.left.left == null && node.left.right == null) {
          ans += node.left.val;
        }
        queue.offer(node.left);
      }
      if (node.right != null) {
        queue.offer(node.right);
      }
    }
    return ans;
  }

  public static void main(String[] args) {

    Solution s = new Solution();
    int ans =
        s.sumOfLeftLeaves(TreeNode.createTreeNode(new Integer[] {3, 9, 20, null, null, 15, 7}));
    System.out.println(ans);
    ans = s.sumOfLeftLeaves(TreeNode.createTreeNode(new Integer[] {1, 2, 3, 4, 5}));
    System.out.println(ans);
  }
}
