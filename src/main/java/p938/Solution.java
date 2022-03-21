package p938;

import util.*;

public class Solution {
  public int rangeSumBST(TreeNode root, int low, int high) {
    if (root == null) return 0;

    if (root.val < low) {
      return rangeSumBST(root.right, low, high);
    }
    if (root.val > high) {
      return rangeSumBST(root.left, low, high);
    }
    int l = rangeSumBST(root.left, low, high);
    int r = rangeSumBST(root.right, low, high);

    return root.val + l + r;
  }
}
