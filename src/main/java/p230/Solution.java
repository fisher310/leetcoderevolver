package p230;

import util.TreeNode;

/** 二叉搜索树中第K小的元素 */
class Solution {

  int ans = 0;
  int count = 0;

  public int kthSmallest(TreeNode root, int k) {
    dfs(root, k);
    return ans;
  }

  private void dfs(TreeNode node, int k) {
    if (node == null) return;
    dfs(node.left, k);
    count++;
    if (count == k) ans = node.val;
    if (count > k) return;
    dfs(node.right, k);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int ans = s.kthSmallest(TreeNode.createTreeNode(new Integer[] {3, 1, 4, null, 2}), 1);
    System.out.println(ans);
  }
}
