package p687;

import util.TreeNode;

class Solution {

    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (null == root) {
            return 0;
        }
        ans = 0;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMax = dfs(node.left);
        int rightMax = dfs(node.right);

        int left = 0;
        int right = 0;
        if (node.left != null && node.val == node.left.val) {
            left = leftMax + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            right = rightMax + 1;
        }
        ans = Math.max(ans, left + right);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        //        TreeNode root = TreeNode.createTreeNode(new Integer[] {5, 4, 5, 1, 1, null, 5});
        // TreeNode root = TreeNode.createTreeNode(new Integer[] {1, 4, 5, 4, 4, null, 5});
        //         TreeNode root = TreeNode.createTreeNode(new Integer[] {1, null, 1, 1, 1, 1, 1,
        // 1});
        TreeNode root =
                TreeNode.createTreeNode(
                        new Integer[] {
                            5, 4, 5, 4, 4, 5, 3, 4, 4, null, null, null, 4, null, null, 4, null,
                            null, 4, null, 4, 4, null, null, 4, 4
                        });
        Solution s = new Solution();
        int ans = s.longestUnivaluePath(root);
        System.out.println(ans);
    }
}
