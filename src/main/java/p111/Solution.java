package p111;

import util.TreeNode;

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : 1 + Math.min(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTreeNode(new Integer[] { 3, 9, 20, null, null, 15, 7 });
        Solution s = new Solution();
        System.out.println(s.minDepth(root));
    }
}