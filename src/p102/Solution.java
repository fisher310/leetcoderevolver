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
        Queue<MyNode> queue = new LinkedList<>();
        queue.offer(new MyNode(root, 0));
        List<List<Integer>> ans = new LinkedList<>();
        int currentLevel = -1;
        List<Integer> levelList = null;
        while(!queue.isEmpty()) {
            MyNode node = queue.poll();
            if (node.level != currentLevel) {
                levelList = new LinkedList<>();
                ans.add(levelList);
                currentLevel = node.level;
            }
            levelList.add(node.node.val);
            if (node.node.left != null) {
                queue.offer(new MyNode(node.node.left, node.level + 1));
            }
            if (node.node.right != null) {
                queue.offer(new MyNode(node.node.right, node.level + 1));
            }

        }
        return ans;
    }

    static class MyNode {

        TreeNode node;
        int level;
        MyNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3,9,20,null,null,15,7});
        Solution s = new Solution();
        System.out.println(s.levelOrder(root));
    }
}