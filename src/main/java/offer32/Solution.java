package offer32;

import util.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> res = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean order = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> levelValues = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (order) {
                    levelValues.addLast(node.val);
                } else {
                    levelValues.addFirst(node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(levelValues);
            order = !order;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> ans = s.levelOrder(TreeNode.createTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7}));
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }

}
