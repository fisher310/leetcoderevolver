package p99;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/** 恢复二叉搜索树 */
class Solution {
  public void recoverTree(TreeNode root) {
    if (root == null) return;
    TreeNode curr = root, pre = null, x = null, y = null;
    while (curr != null) {
      // 如果没有左孩子，就直接走向右树
      if (curr.left == null) {
        if (pre != null && pre.val > curr.val) {
          y = curr;
          if (x == null) x = pre;
        }
        pre = curr;
        curr = curr.right;
      } else {
        TreeNode pred = predecessor(curr);
        // 没有右节点设置链接
        if (pred.right == null) {
          pred.right = curr;
          curr = curr.left;
        } else if (pred.right == curr) {
          // 前继的右节点是本身时说明第二次遍历到了子树的根
          pred.right = null;
          if (pre != null && pre.val > curr.val) {
            y = curr;
            if (x == null) x = pre;
          }
          pre = curr;
          curr = curr.right;
        }
      }
    }
    swap(x, y);
  }

  void swap(TreeNode p1, TreeNode p2) {
    int tmp = p1.val;
    p1.val = p2.val;
    p2.val = tmp;
  }

  TreeNode predecessor(TreeNode root) {
    TreeNode pre = root.left;
    while (pre.right != null && pre.right != root) {
      pre = pre.right;
    }
    return pre;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode root = TreeNode.createTreeNode(new Integer[] {1, 3, null, null, 2});
    s.recoverTree(root);
    List<Integer> list = new LinkedList<>();
    TreeNode.inOrder(root, list);
    System.out.println(list);
    root = TreeNode.createTreeNode(new Integer[] {3, 1, 4, null, null, 2});
    s.recoverTree(root);
    list.clear();
    TreeNode.inOrder(root, list);
    System.out.println(list);

    root = TreeNode.createTreeNode(new Integer[] {2, 3, 1});
    s.recoverTree(root);
    list.clear();
    TreeNode.inOrder(root, list);
    System.out.println(list);
  }
}
