package p513;

import util.TreeNode;

class Solution {
  int maxLevel = 0;
  int ans;

  public int findBottomLeftValue(TreeNode root) {
    dfs(root, 1);
    return ans;
  }

  void dfs(TreeNode node, int level) {
    if (node == null) return;
    dfs(node.left, level + 1);

    if (level > maxLevel) {
      maxLevel = level;
      ans = node.val;
    }
    dfs(node.right, level + 1);
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
