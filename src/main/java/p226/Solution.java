package p226;

import util.TreeNode;

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = s.invertTree(TreeNode.createTreeNode(new Integer[]{4, 2, 7, 1, 3, 6, 9}));

    }
}
