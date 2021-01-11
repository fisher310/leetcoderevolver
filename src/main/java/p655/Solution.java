package p655;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    int col;

    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);

        int col = (1 << height) - 1;
        String[][] res = new String[height][col];
        for (String[] arr : res) {
            Arrays.fill(arr, "");
        }

        dfs(res, root, 0, col, 0);
        List<List<String>> ans = new ArrayList<>(height);
        for (String[] r : res) {
            ans.add(Arrays.asList(r));
        }
        return ans;
    }

    private void dfs(String[][] res, TreeNode root, int left, int right, int level) {
        if (root == null) return;
        int mid = (left + right) >> 1;
        res[level][mid] = String.valueOf(root.val);

        dfs(res, root.left, left, mid, level + 1);
        dfs(res, root.right, (left + right + 1) >> 1, right, level + 1);
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> ans = s.printTree(TreeNode.createTreeNode(new Integer[] {1, 2, 5, 3}));
        for (List<String> r : ans) {
            System.out.println(r);
        }
    }
}
