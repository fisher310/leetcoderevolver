package p114;

import util.TreeNode;

class Solution {
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2, 5, 3, 4, null, 6});
        s.flatten(root);
    }
}
