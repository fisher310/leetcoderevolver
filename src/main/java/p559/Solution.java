package p559;

import util.multi.Node;

import java.util.ArrayList;
import java.util.List;

/** N叉树的最大深度 easy */
class Solution {
  int ans;

  public int maxDepth(Node root) {
    ans = 0;
    dfs(root, 1);
    return ans;
  }

  void dfs(Node node, int dept) {
    if (node == null) return;
    ans = Math.max(ans, dept);
    if (node.children != null) {
      for (Node n : node.children) {
        dfs(n, dept + 1);
      }
    }
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    List<Node> nodes = new ArrayList<>();
    Node e = new Node(3);
    nodes.add(e);
    nodes.add(new Node(2));
    nodes.add(new Node(4));
    root.children = nodes;

    nodes = new ArrayList<>();
    nodes.add(new Node(5));
    nodes.add(new Node(6));
    e.children = nodes;

    Solution s = new Solution();
    int ans = s.maxDepth(root);
    System.out.println(ans);
  }
}
