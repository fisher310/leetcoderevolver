package p112;

import util.TreeNode;

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return dfs(root, 0, sum);
    }

    boolean dfs(TreeNode node, int sum, int target) {
        int val = node.val;

        if (node.left == null && node.right == null) return (sum + val) == target;

        if (node.left != null && dfs(node.left, val + sum, target)) {
            return true;
        }

        if (node.right != null && dfs(node.right, val + sum, target)) {
            return true;
        }
        return false;
    }
}
