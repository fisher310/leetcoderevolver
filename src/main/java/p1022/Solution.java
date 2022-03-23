package p1022;

import org.junit.Assert;

import util.TreeNode;

public class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return help(root, 0);
    }

    int help(TreeNode node, int x) {
        if (node == null) {
            return 0;
        }
        int v = (x << 1) | node.val;
        if (node.left == null && node.right == null) {
            return v;
        }
        int l = help(node.left, v);
        int r = help(node.right, v);

        return l + r;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(22, s.sumRootToLeaf(TreeNode.createTreeNode(new Integer[] { 1, 0, 1, 0, 1, 0, 1 })));
        Assert.assertEquals(1, s.sumRootToLeaf(TreeNode.createTreeNode(new Integer[] { 1 })));
        Assert.assertEquals(3, s.sumRootToLeaf(TreeNode.createTreeNode(new Integer[] { 1, 1 })));
    }
}