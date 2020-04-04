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
    queue.add(null);
    queue.add(target);

    Set<TreeNode> visited = new HashSet<>();
    visited.add(target);
    visited.add(null);

    int dist = 0;
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node == null) {
        if (dist == K) {
          List<Integer> ans = new LinkedList<>();
          for (TreeNode n : queue) {
            ans.add(n.val);
          }
          return ans;
        }
        queue.offer(null);
        dist++;
      } else {
        if (!visited.contains(node.left)) {
          queue.offer(node.left);
          visited.add(node.left);
        }
        if (!visited.contains(node.right)) {
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
    return Collections.emptyList();
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
