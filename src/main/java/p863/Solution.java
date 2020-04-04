package p863;

import util.TreeNode;

import java.util.*;

import static util.TreeNode.find;

/** 二叉树中所有距离为K的节点 */
class Solution {

  Map<TreeNode, TreeNode> parent = new HashMap<>();

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    dfs(root, null);

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(target);

    Set<TreeNode> visited = new HashSet<>();
    visited.add(null);
    visited.add(target);

    List<Integer> ans = new LinkedList<>();
    int dist = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (dist == K) {
          ans.add(node.val);
        } else {
          if (!visited.contains(node.left)) {
            queue.offer(node.left);
            visited.add(node.left);
          }
          if (node.right != null && !visited.contains(node.right)) {
            queue.offer(node.right);
            visited.add(node.right);
          }
          TreeNode par = parent.get(node);
          if (!visited.contains(par)) {
            queue.offer(par);
            visited.add(par);
          }
        }
      }
      dist++;
    }
    return ans;
  }

  void dfs(TreeNode node, TreeNode par) {
    if (node != null) {
      parent.put(node, par);
      dfs(node.left, node);
      dfs(node.right, node);
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode root = TreeNode.createTreeNode(new Integer[] {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
    TreeNode target = find(root, 5);

    List<Integer> ans = s.distanceK(root, target, 2);
    System.out.println(ans);
  }
}
