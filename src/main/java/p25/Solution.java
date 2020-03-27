package p25;

import util.ListNode;

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        int total = 0;
        ListNode h = head;
        while (h != null) {
            total++;
            if (total > k) {
                break;
            }
            h = h.next;
        }

        if (total < k) {
            return head;
        }

        ListNode pre = null, current = head, next = null;
        for (int i = 0; i < k && current != null; i++) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        head.next = reverseKGroup(current, k);
        return pre;
    }
}
