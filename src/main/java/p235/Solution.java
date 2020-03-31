package p235;

import util.TreeNode;

/**
 * 二叉搜索树的最近公共祖先
 */
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
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
