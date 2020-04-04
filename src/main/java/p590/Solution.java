package p590;

import util.multi.Node;

import java.util.LinkedList;
import java.util.List;

/** N叉树的后续遍历 */
class Solution {
  public List<Integer> postorder(Node root) {
    List<Integer> list = new LinkedList<>();
    postorder(root, list);
    return list;
  }

  private void postorder(Node node, List<Integer> list) {
    if (node == null) return;
    if (node.children != null) {
      for (Node n : node.children) {
        postorder(n, list);
      }
    }
    list.add(node.val);
  }
}
