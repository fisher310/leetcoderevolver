package p538;

import util.TreeNode;

class Solution {

  private int sum = 0;

  public TreeNode convertBST(TreeNode root) {
    dfs(root);
    return root;
  }

  void dfs(TreeNode node) {
    if (node == null) return;
    dfs(node.right);
    node.val = node.val + sum;
    sum = node.val;
    dfs(node.left);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode root = s.convertBST(TreeNode.createTreeNode(new Integer[] {5, 2, 13, 1, 3}));
  }
}
