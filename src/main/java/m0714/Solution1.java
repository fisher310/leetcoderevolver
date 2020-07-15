package m0714;

import util.ListNode;
import util.ListNodeUtil;

public class Solution1 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy.next;
        ListNode slow = dummy.next;

        int len = 0;
        while (k > 0) {
            if (fast != null)
                len++;
            else {
                k %= len;
                fast = head;
                continue;
            }
            fast = fast.next;
            k--;
        }
        if (fast == null || head == fast)
            return head;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        dummy.next = slow.next;
        slow.next = null;
        fast.next = head;
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        ListNodeUtil.print(s.rotateRight(ListNodeUtil.create(new int[] { 1, 2, 3, 4, 5 }), 10));
        ListNodeUtil.print(s.rotateRight(ListNodeUtil.create(new int[] { 1 }), 1));
        ListNode head = s.rotateRight(ListNodeUtil.create(new int[] { 1, 2, 3, 4, 5 }), 2);
        ListNodeUtil.print(head);
        ListNodeUtil.print(s.rotateRight(ListNodeUtil.create(new int[] { 0, 1, 2 }), 4));
    }

}