package p501;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  private int count;
  private int max;
  private Integer pre;
  private List<Integer> ans = new ArrayList<>();

  public int[] findMode(TreeNode root) {
    if (root == null) return new int[] {};
    inorder(root);
    int[] s = new int[ans.size()];
    for (int i = 0, n = s.length; i < n; i++) {
      s[i] = ans.get(i);
    }
    return s;
  }

  void inorder(TreeNode root) {
    if (root == null) return;

    inorder(root.left);
    if (pre != null && pre == root.val) {
      count++;
    } else {
      count = 1;
    }
    pre = root.val;
    if (count == max) {
      ans.add(root.val);
    } else if (count > max) {
      ans.clear();
      ans.add(root.val);
      max = count;
    }

    inorder(root.right);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] mode = s.findMode(TreeNode.createTreeNode(new Integer[] {1, null, 2, 2}));
    System.out.println(Arrays.toString(mode));
  }
}
