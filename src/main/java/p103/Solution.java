package p103;

import util.TreeNode;

import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (null == root) return Collections.emptyList();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean left = true;
        queue.offer(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> le = new LinkedList<>();
            for (int j = 0; j < size; j++) {
                TreeNode node = queue.poll();
                if (left) {
                    le.addLast(node.val);
                } else {
                    le.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            left = !left;
            ans.add(le);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> ans =
                s.zigzagLevelOrder(
                        TreeNode.createTreeNode(new Integer[]{1, 2, 3, 4, null, null, 5}));
        System.out.println(ans);
        System.out.println(
                s.zigzagLevelOrder(TreeNode.createTreeNode(new Integer[]{1, 2, 3, 4, 5})));
        System.out.println(
                s.zigzagLevelOrder(
                        TreeNode.createTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(s.zigzagLevelOrder(TreeNode.createTreeNode(new Integer[]{})));
    }
}
