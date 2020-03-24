package p98;

import util.TreeNode;

class Solution {
    public boolean isValidBST(TreeNode root) {
        return doValid(root, null, null);
    }

    private boolean doValid(TreeNode node, Integer lower, Integer upper) {
        if (null == node) {
            return true;
        }
        int val = node.val;
        if (lower != null && val <= lower)
            return false;
        if (upper != null && val >= upper)
            return false;

        if (!doValid(node.right, val, upper))
            return false;
        if (!doValid(node.left, lower, val))
            return false;
        return true;
    }

    public static void main(String[] args) {
        // TreeNode root = TreeNode.creatTreeNode(new Integer[]{5,1,4,null, null, 3,
        // 6});
        TreeNode root = TreeNode.createFullTreeNode(new Integer[] { 10, 5, 15, null, null, 6, 20 });
        Solution s = new Solution();
        System.out.println(s.isValidBST(root));
    }
}