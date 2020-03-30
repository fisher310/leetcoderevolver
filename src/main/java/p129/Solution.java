package p129;

import util.TreeNode;

/**
 * 求根到叶子节点数字之和
 */
class Solution {

    int ans = 0;

    public int sumNumbers(TreeNode root) {
        ans = 0;
        dfs(root, 0);
        return ans;
    }

    void dfs(TreeNode node, int preNum) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            ans += preNum * 10 + node.val;
            return;
        }

        if (node.left != null) {
            dfs(node.left, preNum * 10 + node.val);
        }

        if (node.right != null) {
            dfs(node.right, preNum * 10 + node.val);
        }
    }

    public static void main(String[] args) {
        int ans = new Solution().sumNumbers(TreeNode.createTreeNode(new Integer[]{1, 2, 3}));
        System.out.println(ans);

        ans = new Solution().sumNumbers(TreeNode.createTreeNode(new Integer[]{4, 9, 0, 5, 1}));
        System.out.println(ans);
    }
}
