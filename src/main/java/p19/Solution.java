package p19;

import util.ListNode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i <= n; i++) {
            if (fast == null) {
                return head.next;
            }
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next == null ? null : slow.next.next;
        return head;
    }
}
