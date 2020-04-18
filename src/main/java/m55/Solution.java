package m55;

import util.TreeNode;

/**
 * 平衡二叉树
 */
class Solution {
    private boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (!ans) return -1;
        if (node == null) return 0;
        int l = dfs(node.left);
        int r = dfs(node.right);
        if (Math.abs(l - r) > 1) {
            ans = false;
        }
        return Math.max(l, r) + 1;
    }
}
