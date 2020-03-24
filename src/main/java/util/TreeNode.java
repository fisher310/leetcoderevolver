package util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int x) {
    this.val = x;
  }

  public static TreeNode createFullTreeNode(Integer[] input) {
    if (input == null || input.length == 0) {
      return null;
    }
    TreeNode[] nodes = new TreeNode[input.length];
    for (int i = 0, n = input.length; i < n; i++) {
      if (input[i] != null) {
        nodes[i] = new TreeNode(input[i]);
      } else {
        nodes[i] = null;
      }
    }

    for (int i = 0, n = input.length; i < n; i++) {
      if (i * 2 + 1 < n && nodes[i] != null) {
        nodes[i].left = nodes[i * 2 + 1];
      }

      if (nodes[i] != null && i * 2 + 2 < n) {
        nodes[i].right = nodes[i * 2 + 2];
      }
    }
    return nodes[0];
  }

  public static TreeNode createTreeNode(Integer[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    TreeNode root = new TreeNode(nums[0]);
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int i = 1;
    while (!queue.isEmpty() && i < nums.length) {
      TreeNode current = queue.poll();
      Integer nl = nums[i++];
      if (nl != null) {
        current.left = new TreeNode(nl);
        queue.offer(current.left);
      }
      if (i < nums.length) {
        Integer nr = nums[i++];
        if (nr != null) {
          current.right = new TreeNode(nr);
          queue.offer(current.right);
        }
      }
    }
    return root;
  }


  public static void inOrder(TreeNode root, List<Integer> list) {
    if (root.left != null) {
      inOrder(root.left, list);
    }
    list.add(root.val);
    if (root.right != null) {
      inOrder(root.right, list);
    }
  }

  public static void main(String[] args) {
    TreeNode root = createFullTreeNode(new Integer[] {2, 1, 4});
    List<Integer> list = new ArrayList<>();
    inOrder(root, list);
    System.out.println(list);
  }
}
