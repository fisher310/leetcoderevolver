package p101;

import util.TreeNode;

/**
 * 对称二叉树
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSame(root, root);
    }

    boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return (p.val == q.val) && isSame(p.left, q.right) && isSame(p.right, q.left);
    }
}
