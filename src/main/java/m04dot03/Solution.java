package m04dot03;

import util.ListNode;
import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public ListNode[] listOfDepth(TreeNode tree) {

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);

        List<ListNode> res = new ArrayList<>();
        ListNode dummy = new ListNode(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode curr = dummy;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                curr.next = new ListNode(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                curr = curr.next;
            }
            res.add(dummy.next);
            dummy.next = null;
        }

        return res.toArray(new ListNode[] {});
    }
}
