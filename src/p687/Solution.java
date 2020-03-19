package p687;

import util.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public int longestUnivaluePath(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int max = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int dfsL = 0;
            int dfsR = 0;
            if (current.left != null && current.val == current.left.val) {
               dfsL= dfs(current.left, 1) ;
            }
            if (current.right != null && current.val == current.right.val) {
                dfsR = dfs(current.right, 1);
            }
            if (dfsL + dfsR > max) {
                max = dfsL + dfsR;
            }
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return max;
    }

    private int dfs(TreeNode node, int path) {
        if (node == null) {
            return path;
        }
        int left = path;
        int right = path;
        if (node.left != null && node.val == node.left.val) {
            left = dfs(node.left, path + 1);
        }
        if (node.right != null && node.right.val == node.val) {
            right = dfs(node.right, path + 1);
        }
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        //        TreeNode root = TreeNode.createTreeNode(new Integer[] {5, 4, 5, 1, 1, null, 5});
        // TreeNode root = TreeNode.createTreeNode(new Integer[] {1, 4, 5, 4, 4, null, 5});
        //         TreeNode root = TreeNode.createTreeNode(new Integer[] {1, null, 1, 1, 1, 1, 1,
        // 1});
        TreeNode root =
                TreeNode.createTreeNode(
                        new Integer[] {
                            5, 4, 5, 4, 4, 5, 3, 4, 4, null, null, null, 4, null, null, 4, null,
                            null, 4, null, 4, 4, null, null, 4, 4
                        });
        Solution s = new Solution();
        int ans = s.longestUnivaluePath(root);
        System.out.println(ans);
    }
}
