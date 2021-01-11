package p965;

import util.TreeNode;

/**
 * @author lihailong
 * @since 2020/12/16 0016
 */
class Solution {

    public boolean isUnivalTree(TreeNode root) {
        return help(root, root.val);
    }

    public boolean help(TreeNode root, int val) {
        if (root == null) return true;
        if (root.val != val) return false;
        if (!help(root.left, val)) {
            return false;
        }

        return help(root.right, val);
    }
}
