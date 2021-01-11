package m04dot12;

import util.TreeNode;

/**
 * @author lihailong
 * @since 2021/1/5 0005
 */
class Solution {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) return 0;
        sum -= root.val;
        return (sum == 0 ? 1 : 0) + dfs(root.left, sum) + dfs(root.right, sum);
    }
}
