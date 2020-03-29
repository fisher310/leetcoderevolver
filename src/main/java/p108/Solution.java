package p108;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (null == nums || nums.length == 0) return null;
        return helper(nums, 0, nums.length);
    }

    TreeNode helper(int[] nums, int inLeft, int inRight) {
        if (inLeft == inRight) {
            return null;
        }
        int mid = (inLeft + inRight) / 2;
        int value = nums[mid];
        TreeNode root = new TreeNode(value);
        root.left = helper(nums, inLeft, mid);
        root.right = helper(nums, mid + 1, inRight);
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = s.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        List<Integer> list = new ArrayList();
        TreeNode.inOrder(root, list);
        System.out.println(list);
    }
}
