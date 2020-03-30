package p124;

import util.TreeNode;

class Solution {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        max(root);
        return ans;
    }

    int max(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            ans = Math.max(ans, node.val);
            return node.val;
        }
        int val = node.val;
        int nodeMax = val;
        int leftMax = 0;
        int rightMax = 0;
        if (node.left != null) {
            leftMax = max(node.left);
        }
        if (node.right != null) {
            rightMax = max(node.right);
        }
        nodeMax = Math.max(val, Math.max(val + leftMax, val + rightMax));
        ans = Math.max(ans, Math.max(nodeMax, val + leftMax + rightMax));
        return nodeMax;
    }

    public static void main(String[] args) {
        int ans = new Solution().maxPathSum(TreeNode.createTreeNode(new Integer[]{0}));
        System.out.println(ans);

        int sum = new Solution().maxPathSum(TreeNode.createTreeNode(new Integer[]{1, 2, 3}));
        System.out.println(sum);

        sum = new Solution().maxPathSum(TreeNode.createTreeNode(new Integer[]{-10, 9, 20, null, null, 15, 7}));
        System.out.println(sum);
    }
}
