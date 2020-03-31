package p235;

import util.TreeNode;

/**
 * 二叉搜索树的最近公共祖先
 */
class Solution {

    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return ans;
    }

    boolean find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        boolean self = root.val == p.val || root.val == q.val;
        boolean l = find(root.left, p, q);
        if (self && l) {
            ans = root;
            return true;
        }
        boolean r = find(root.right, p, q);
        if (self && r) {
            ans = root;
            return true;
        }
        if (l && r && ans == null) ans = root;
        return self || l || r;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode ancestor =
                s.lowestCommonAncestor(
                        TreeNode.createTreeNode(
                                new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5}),
                        new TreeNode(2),
                        new TreeNode(4));
        System.out.println(ancestor.val);
    }
}
