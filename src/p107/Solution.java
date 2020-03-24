package p107;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 二叉树的层次遍历
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
 /  \
 15   7
 返回其自底向上的层次遍历为：

 [
 [15,7],
 [9,20],
 [3]
 ]
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        LinkedList<List<Integer>> ans = new LinkedList<>();
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> levelList = new LinkedList<>();
            ans.addFirst(levelList);
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTreeNode(new Integer[] { 3, 9, 20, null, null, 15, 7 });
        Solution s = new Solution();
        System.out.println(s.levelOrderBottom(root));
    }
    
}