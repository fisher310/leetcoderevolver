package p95;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            TreeNode root = new TreeNode(i);
        }

        return ans;
    }

    TreeNode dfs(int cur, int n, List<TreeNode> res) {

        return null;
    }
}
