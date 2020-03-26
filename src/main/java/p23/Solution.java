package p23;

import util.ListNode;

import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (ListNode node : lists) {
            while (node != null) {
                heap.add(node.val);
                node = node.next;
            }
        }

        ListNode head = new ListNode(0);
        ListNode current = head;
        while (!heap.isEmpty()) {
            current.next = new ListNode(heap.poll());
            current = current.next;
        }
        return head.next;
    }
}
