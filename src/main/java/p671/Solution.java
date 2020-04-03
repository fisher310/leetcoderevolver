package p671;

import util.TreeNode;

/** 二叉树中第二小的节点 */
class Solution {
  private Integer min;
  private int sec;

  public int findSecondMinimumValue(TreeNode root) {
    if (root == null) return -1;
    min = null;
    sec = -1;
    dfs(root);
    return sec;
  }

  void dfs(TreeNode root) {
    if (root == null) return;
    int val = root.val;
    if (min == null) {
      min = val;
    } else if (min < val && (sec == -1 || sec > val)) {
      sec = val;
    } else if (min > val) {
      sec = min;
      min = val;
    }
    dfs(root.left);
    dfs(root.right);
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    //    int sec =
    //        s.findSecondMinimumValue(TreeNode.createTreeNode(new Integer[] {2, 5, null, null, 5,
    // 7}));
    //    System.out.println(sec);
    //    sec = new Solution().findSecondMinimumValue(TreeNode.createTreeNode(new Integer[] {2, 2,
    // 2}));
    //    System.out.println(sec);
  }
}
