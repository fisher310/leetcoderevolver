package p429;

import util.multi.Node;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N叉树的层序遍历 mid
 */
class Solution {
  public List<List<Integer>> levelOrder(Node root) {
    if (root == null) return Collections.emptyList();
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    List<List<Integer>> ans = new LinkedList<>();
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> levelList = new LinkedList<>();
      for (int i = 0; i < size; i++) {
        Node n = queue.poll();
        levelList.add(n.val);
        if (n.children != null) {
          for (Node c : n.children) {
            queue.offer(c);
          }
        }
      }
      ans.add(levelList);
    }
    return ans;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
  }
}
