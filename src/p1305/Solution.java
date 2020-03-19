package p1305;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    List<Integer> a = new ArrayList<>();
    List<Integer> b = new ArrayList<>();
    inOrder(root1, a);
    inOrder(root2, b);
    int capacity = a.size() + b.size();
    if (a.isEmpty()) {
      return b;
    }
    if (b.isEmpty()) {
      return a;
    }
    List<Integer> result = new ArrayList<>(capacity);
    int i = 0, j = 0;
    while (i < a.size() || j < b.size()) {
      if (i < a.size() && (j >= b.size() || a.get(i) <= b.get(j))) {
        result.add(a.get(i++));
      } else {
        result.add(b.get(j++));
      }
    }

    return result;
  }

  public void inOrder(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    if (root.left != null) {
      inOrder(root.left, list);
    }
    list.add(root.val);
    if (root.right != null) {
      inOrder(root.right, list);
    }
  }

  public static void main(String[] args) {
    TreeNode root1 = TreeNode.createFullTreeNode(new Integer[] {2, 1, 4});
    TreeNode root2 = TreeNode.createFullTreeNode(new Integer[] {1, 0, 3});
    Solution s = new Solution();
    System.out.println(s.getAllElements(root1, root2));
  }
}
