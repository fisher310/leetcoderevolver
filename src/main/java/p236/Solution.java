package p236;

import util.TreeNode;

/**
 * 二叉树的最近公共祖先
 */
class Solution {
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return ans;
    }

    private boolean find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        int val = root.val;
        boolean self = val == p.val || val == q.val;

        boolean l = find(root.left, p, q);
        boolean r = find(root.right, p, q);

        if ((self && l) || (self && r) || (ans == null && l && r)) {
            ans = root;
            return true;
        }

        return self || l || r;
    }
}
