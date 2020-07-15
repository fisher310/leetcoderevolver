package m0710;

import util.TreeNode;

class Solution1 {

    int ans;

    public int goodNodes(TreeNode root) {
        ans = 0;

        dfs(root, root.val);

        return ans;
    }

    private void dfs(TreeNode root, int max) {

        if (root == null) {
            return;
        }

        if (root.val >= max)
            ans++;

        dfs(root.left, Math.max(max, root.val));
        dfs(root.right, Math.max(max, root.val));
    }

}