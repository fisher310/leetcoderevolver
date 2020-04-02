package p404;

import util.TreeNode;

class Solution {
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) return 0;
    int val = 0;
    if (root.left != null && root.left.left == null && root.left.right == null) {
      val = root.left.val;
    }
    int l = sumOfLeftLeaves(root.left);
    int r = sumOfLeftLeaves(root.right);
    return val + l + r;
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
