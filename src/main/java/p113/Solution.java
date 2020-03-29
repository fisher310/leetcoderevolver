package p113;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(new ArrayList<>(), root, 0, sum);
        return ans;
    }

    void dfs(List<Integer> list, TreeNode node, int sum, int target) {
        if (node == null) return;

        int val = node.val;
        list.add(val);
        if (node.left == null && node.right == null && (sum + val) == target) {
            ans.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        dfs(list, node.left, sum + val, target);
        dfs(list, node.right, sum + val, target);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> ans = s.pathSum(TreeNode.createTreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22);
        System.out.println(ans);
        ans = new Solution().pathSum(TreeNode.createTreeNode(new Integer[]{1}), 0);
        System.out.println(ans);
        ans = new Solution().pathSum(TreeNode.createTreeNode(new Integer[]{1, 2}), 1);
        System.out.println(ans);
    }
}
