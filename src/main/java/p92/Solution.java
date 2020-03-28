package p92;

import util.ListNode;

/**
 * 翻转位置m 到 n的链表 1->2->3->4->5->null 1->4->3->2->5->null
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        int pos = 0;
        m = m - 1;
        n = n - 1;
        ListNode pre = null, curr = head, next = null;
        ListNode first = null;
        ListNode second = null;
        ListNode last = null;
        while (pos < m) {
            if (pos == m - 1) {
                first = curr;
            }
            curr = curr.next;
            pos++;
        }
        second = curr;

        while (pos <= n && curr != null) {
            if (pos == n) {
                last = curr.next;
            }
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
            pos++;
        }
        if (second != null) {
            second.next = last;
        }

        if (first != null) {
            first.next = pre;
            return head;
        }

        return pre;
    }
}
