package p437;

import util.TreeNode;

class Solution {

  public int pathSum(TreeNode root, int sum) {
    if (root == null) return 0;

    int res = 0;

    res += findPath(root, sum);
    res += pathSum(root.left, sum);
    res += pathSum(root.right, sum);
    return res;
  }

  private int findPath(TreeNode node, int sum) {
    if (node == null) return 0;

    int res = 0;
    if (node.val == sum) {
      res += 1;
    }
    res += findPath(node.left, sum - node.val);
    res += findPath(node.right, sum - node.val);
    return res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int ans =
        s.pathSum(
            TreeNode.createTreeNode(new Integer[] {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}), 8);
    System.out.println(ans);
  }
}
