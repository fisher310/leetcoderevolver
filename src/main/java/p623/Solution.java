package p623;

import util.TreeNode;

/** 在二叉树中增加一行 */
class Solution {
  public TreeNode addOneRow(TreeNode root, int v, int d) {
    if (d == 1) {
      TreeNode n = new TreeNode(v);
      n.left = root;
      return n;
    }
    dfs(root, v, d, 1);
    return root;
  }

  void dfs(TreeNode node, int v, int d, int level) {
    if (node == null) return;
    if (level == d - 1) {
      TreeNode tmpL = node.left;
      TreeNode tmpR = node.right;
      node.left = new TreeNode(v);
      node.left.left = tmpL;
      node.right = new TreeNode(v);
      node.right.right = tmpR;
    }
    dfs(node.left, v, d, level + 1);
    dfs(node.right, v, d, level + 1);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode n = s.addOneRow(TreeNode.createTreeNode(new Integer[] {4, 2, null, 3, 1}), 1, 3);
    TreeNode root = s.addOneRow(TreeNode.createTreeNode(new Integer[] {4, 2, 6, 3, 5, 1}), 1, 3);
  }
}
