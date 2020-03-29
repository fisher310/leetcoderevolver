package p114;

import util.TreeNode;

class Solution {
    public void flatten(TreeNode root) {
        dfs(root);
    }

    TreeNode dfs(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) {
            return node;
        }

        TreeNode left = node.left;
        TreeNode right = node.right;

        node.left = null;
        node.right = dfs(left);
        TreeNode curr = node;
        while (curr.right != null) {
            curr = curr.right;
        }
        curr.right = dfs(right);
        return node;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2, 5, 3, 4, null, 6});
        s.flatten(root);
    }
}
