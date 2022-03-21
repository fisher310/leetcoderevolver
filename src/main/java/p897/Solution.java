package p897;

import java.util.*;
import util.*;

public class Solution {

  public TreeNode increasingBST(TreeNode root) {
    List<Integer> values = new ArrayList<>();
    dfs(root, values);
    return build(values);
  }

  void dfs(TreeNode root, List<Integer> values) {
    if (root == null) return;
    dfs(root.left, values);
    values.add(root.val);
    dfs(root.right, values);
  }

  TreeNode build(List<Integer> values) {
    TreeNode dummy = new TreeNode(-1);
    TreeNode pre = dummy;
    for (int v : values) {
      TreeNode node = new TreeNode(v);
      pre.right = node;
      pre = node;
    }

    return dummy.right;
  }
}
