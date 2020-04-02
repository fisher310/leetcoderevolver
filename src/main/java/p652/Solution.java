package p652;

import util.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
  List<TreeNode> ans;
  Map<String, Integer> map;

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    ans = new LinkedList<>();
    map = new HashMap<>();
    dfs(root);
    return ans;
  }

  String dfs(TreeNode node) {
    if (node == null) return "#";
    String s = node.val + "," + dfs(node.left) + "," + dfs(node.right);
    map.put(s, map.getOrDefault(s, 0) + 1);
    if (map.get(s) == 2) {
      ans.add(node);
    }
    return s;
  }

  public static void main(String[] args) {
    Solution s  = new Solution();
    s.findDuplicateSubtrees(TreeNode.createTreeNode(new Integer[]{1,2,3,4,null,2,4,null,null,4}));
    System.out.println(s);
  }
}
