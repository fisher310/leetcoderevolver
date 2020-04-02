package p337;

import util.TreeNode;

class Solution {
  public int rob(TreeNode root) {
    int[] ans = dfs(root);
    return Math.max(ans[0], ans[1]);
  }

  private int[] dfs(TreeNode node) {
    if (node == null) {
      return new int[] {0, 0};
    }
    int[] cl = dfs(node.left);
    int[] cr = dfs(node.right);

    int choose = node.val + cl[1] + cr[1];
    int noChoose = Math.max(cl[0], cl[1]) + Math.max(cr[0], cr[1]);
    return new int[] {choose, noChoose};
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int ans = s.rob(TreeNode.createTreeNode(new Integer[] {3, 2, 3, null, 3, null, 1}));
    System.out.println(ans);
  }
}
