package p100;

import util.TreeNode;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isSameTree(TreeNode.createTreeNode(new Integer[]{1, 2, 3}), TreeNode.createTreeNode(new Integer[]{1, 2, 3})));
        System.out.println(s.isSameTree(TreeNode.createTreeNode(new Integer[]{1, 2}), TreeNode.createTreeNode(new Integer[]{1, null, 2})));
    }
}
