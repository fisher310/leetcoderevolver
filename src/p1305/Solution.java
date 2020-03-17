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
    for (int i = 0, j = 0, k = 0; k < capacity; k++) {
      if (i >= a.size() && j < b.size()) {
        result.add(b.get(j++));
      }
      if (i < a.size() && j >= b.size()) {
        result.add(a.get(i++));
      }

      if (i < a.size() && j < b.size()) {
        int va = a.get(i);
        int vb = b.get(j);
        if (va < vb) {
          result.add(va);
          i++;
        } else {
          result.add(vb);
          j++;
        }
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
    TreeNode root1 = TreeNode.createTreeNode(new Integer[] {});
    TreeNode root2 = TreeNode.createTreeNode(new Integer[] {5, 1, 7, 0, 2});
    Solution s = new Solution();
    System.out.println(s.getAllElements(root1, root2));
  }
}
