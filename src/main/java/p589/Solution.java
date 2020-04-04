package p589;

import util.multi.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * N叉树的前序遍历
 */
class Solution {
  public List<Integer> preorder(Node root) {
    List<Integer> list = new LinkedList<>();
    preorder(root, list);
    return list;
  }

  void preorder(Node root, List<Integer> list) {
    if (root == null) return;
    list.add(root.val);
    if (root.children != null) {
      for (Node n : root.children) {
        preorder(n, list);
      }
    }
  }
}
