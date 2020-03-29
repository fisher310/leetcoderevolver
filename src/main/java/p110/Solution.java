package p110;

import org.junit.Assert;
import util.TreeNode;

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertFalse(
                s.isBalanced(TreeNode.createTreeNode(new Integer[]{1, null, 2, null, 3})));
        Assert.assertTrue(
                s.isBalanced(TreeNode.createTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }
}
