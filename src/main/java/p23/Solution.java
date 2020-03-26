package p23;

import util.ListNode;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        ListNode l1 = merge(lists, start, mid);
        ListNode l2 = merge(lists, mid + 1, end);
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
                current = current.next;
            } else {
                current.next = l2;
                l2 = l2.next;
                current = current.next;
            }
        }
        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;
        return head.next;
    }
}
