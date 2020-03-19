package p102;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

/**
 * 二叉树层次遍历 <br>
 * 
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],
<p>
    3
   / \
  9  20
    /  \
   15   7
<p/>
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> ans = new LinkedList<>();
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> levelList = new LinkedList<>();
            ans.add(levelList);
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
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3,9,20,null,null,15,7});
        Solution s = new Solution();
        System.out.println(s.levelOrder(root));
    }
}