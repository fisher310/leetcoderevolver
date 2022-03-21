package p872;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import util.*;

public class Solution {

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {

    List<Integer> leaf1 = new ArrayList<>();
    List<Integer> leaf2 = new ArrayList<>();

    dfs(root1, leaf1);
    dfs(root2, leaf2);
    if (leaf1.size() != leaf2.size()) {
      return false;
    }

    for (int i = 0; i < leaf1.size(); i++) {
      if (leaf1.get(i) != leaf2.get(i)) {
        return false;
      }
    }

    return true;
  }

  void dfs(TreeNode root, List<Integer> leafs) {
    if (root == null) return;
    if (root.left == null && root.right == null) {
      leafs.add(root.val);
      return;
    }

    dfs(root.left, leafs);
    dfs(root.right, leafs);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    Assert.assertFalse(
        s.leafSimilar(
            TreeNode.createTreeNode(new Integer[] {1, 2, 3}),
            TreeNode.createTreeNode(new Integer[] {1, 3, 2})));
  }
}
