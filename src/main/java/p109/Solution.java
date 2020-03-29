package p109;

import util.ListNode;
import util.ListNodeUtil;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;

        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        return helper(list, 0, list.size());
    }

    TreeNode helper(List<Integer> list, int inLeft, int inRiglt) {
        if (inLeft == inRiglt) return null;

        int mid = (inLeft + inRiglt) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = helper(list, inLeft, mid);
        root.right = helper(list, mid + 1, inRiglt);
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = s.sortedListToBST(ListNodeUtil.create(new int[]{-10, -3, 0, 5, 9}));
        List<Integer> list = new ArrayList<>();
        TreeNode.inOrder(root, list);
        System.out.println(list);
    }
}
