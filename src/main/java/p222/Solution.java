package p222;

import util.TreeNode;

class Solution {
    private int ans = 0;

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        countNodes(root.left);
        countNodes(root.right);
        ans++;
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.countNodes(TreeNode.createTreeNode(new Integer[]{1, 2, 3, 4, 5, 6}));
        System.out.println(ans);
    }
}
