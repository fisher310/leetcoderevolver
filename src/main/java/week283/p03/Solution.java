package week283.p03;

import util.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lihailong
 * @since 2022-03-06 10:26:48
 */
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {

  public TreeNode createBinaryTree(int[][] descriptions) {

    Map<Integer, TreeNode> map = new HashMap<>();
    Map<Integer, Boolean> parents = new HashMap<>();
    for (int i = 0; i < descriptions.length; i++) {
      int parent = descriptions[i][0];
      int child = descriptions[i][1];
      boolean isLeft = descriptions[i][2] == 1;

      TreeNode parentNode = map.getOrDefault(parent, new TreeNode(parent));
      TreeNode childNode = map.getOrDefault(child, new TreeNode(child));
      if (isLeft) {
        parentNode.left = childNode;
      } else {
        parentNode.right = childNode;
      }

      map.put(parent, parentNode);
      map.put(child, childNode);

      parents.put(child, false);
      if (!parents.containsKey(parent) || parents.get(parent) != false) {
        parents.put(parent, true);
      }
    }

    TreeNode ans = null;
    for (Map.Entry<Integer, Boolean> en : parents.entrySet()) {
      if (en.getValue()) {
        ans = map.get(en.getKey());
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(
        s.createBinaryTree(
            ArrayUtils.getInput2("[[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]")).val);
    System.out.println(s.createBinaryTree(ArrayUtils.getInput2("[[1,2,1],[2,3,0],[3,4,1]]")).val);
  }
}
