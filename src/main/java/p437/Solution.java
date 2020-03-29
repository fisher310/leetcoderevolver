package p437;

import util.TreeNode;

class Solution {

    int ans = 0;

    public int pathSum(TreeNode root, int sum) {
        inOrder(root, sum);
        return ans;
    }

    void find(TreeNode node, int sum, int target) {
        if (node == null) return;

        int val = node.val;
        if (sum + val == target) {
            ans++;
        }

        find(node.left, sum + val, target);
        find(node.right, sum + val, target);
    }

    void inOrder(TreeNode node, int target) {
        if (node == null) return;
        find(node, 0, target);
        inOrder(node.left, target);
        inOrder(node.right, target);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.pathSum(TreeNode.createTreeNode(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}), 8);
        System.out.println(ans);
    }
}
