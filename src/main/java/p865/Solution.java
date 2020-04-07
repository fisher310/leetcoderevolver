package p865;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 具有所有最深节点的最小子树 */
public class Solution {

  Map<TreeNode, TreeNode> parent = new HashMap<>();
  int max = -1;
  List<TreeNode> deepest = new ArrayList<>();

  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    dfs(root, 0);
    if (deepest.size() == 1) {
      return deepest.get(0);
    } else {

      TreeNode ans = null;
      while (ans != root) {
        boolean flag = true;
        ans = parent.get(deepest.get(0));
        for (int i = 1; i < deepest.size(); i++) {
          if (parent.get(deepest.get(i)) != ans) {
            flag = false;
            break;
          }
        }
        if (!flag) {
          for (int i = 0; i < deepest.size(); i++) {
            deepest.set(i, parent.get(deepest.get(i)));
          }
        } else {
          return ans;
        }
      }
    }
    return root;
  }

  void dfs(TreeNode node, int level) {
    if (node == null) return;
    if (level > max) {
      deepest.clear();
      deepest.add(node);
      max = level;
    } else if (level == max) {
      deepest.add(node);
    }

    if (node.left != null) {
      parent.put(node.left, node);
      dfs(node.left, level + 1);
    }

    if (node.right != null) {
      parent.put(node.right, node);
      dfs(node.right, level + 1);
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    TreeNode ans = s.subtreeWithAllDeepest(TreeNode.createTreeNode(new Integer[] {1}));

    ans =
        s.subtreeWithAllDeepest(
            TreeNode.createTreeNode(new Integer[] {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}));
  }
}
