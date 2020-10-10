package p142;

import util.ListNode;

/**
 * 环形链表 II
 */
class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode seed = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                seed = fast;
                break;
            }
        }

        if (seed == null) return null;

        ListNode p1 = head;
        ListNode p2 = seed;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(0);
        n2.next = n3;
        ListNode n4 = new ListNode(-4);
        n3.next = n4;
        n4.next = n2;

        Solution s = new Solution();
        ListNode ans = s.detectCycle(n1);
        System.out.println(ans.val);
    }
}
