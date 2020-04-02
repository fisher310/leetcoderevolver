package p637;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 二叉树的层平均值 */
class Solution {
  public List<Double> averageOfLevels(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    List<Double> ans = new LinkedList<>();
    while (!queue.isEmpty()) {
      int size = queue.size();
      double sum = 0;
      for (int i = 0; i < size; i++) {
        TreeNode n = queue.poll();
        sum += n.val;
        if (n.left != null) queue.offer(n.left);
        if (n.right != null) queue.offer(n.right);
      }
      ans.add(sum / size);
    }
    return ans;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    List<Double> ans =
        s.averageOfLevels(TreeNode.createTreeNode(new Integer[] {3, 9, 20, null, null, 15, 7}));
    for (double d : ans) {
      System.out.print(d + " ");
    }
  }
}
