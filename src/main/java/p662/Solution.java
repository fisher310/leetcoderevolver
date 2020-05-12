package p662;

import org.junit.Assert;
import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/** 662. 二叉树最大宽度 */
class Solution {

  Map<Integer, Integer[]> map = new HashMap<>();
  int ans = 0;

  public int widthOfBinaryTree(TreeNode root) {
    if (root == null) return 0;
    ans = 1;
    dfs(root.left, 1, -1);
    dfs(root.right, 1, 1);
    return ans;
  }

  void dfs(TreeNode root, int level, int w) {

  }

  public static void main(String[] args) {
    Solution s = new Solution();
    Assert.assertEquals(
        8,
        s.widthOfBinaryTree(
            TreeNode.createTreeNode(new Integer[] {1, 1, 1, 1, null, null, 1, 1, null, null, 1})));
    Assert.assertEquals(
        4, s.widthOfBinaryTree(TreeNode.createTreeNode(new Integer[] {1, 3, 2, 5, 3, null, 9})));
  }
}
