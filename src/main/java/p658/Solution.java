package p658;

import util.TreeNode;

/** 最大二叉树 */
class Solution {
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return construct(nums, 0, nums.length);
  }

  TreeNode construct(int[] nums, int start, int end) {
    if (start >= end) return null;
    // find max value
    int max = Integer.MIN_VALUE;
    int pos = start;
    for (int i = start; i < end; i++) {
      if (max < nums[i]) {
        max = nums[i];
        pos = i;
      }
    }
    TreeNode n = new TreeNode(max);
    n.left = construct(nums, start, pos);
    n.right = construct(nums, pos + 1, end);
    return n;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode root = s.constructMaximumBinaryTree(new int[] {3, 2, 1, 6, 0, 5});
  }
}
