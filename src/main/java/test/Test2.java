package test;

import util.ListNode;
import util.ListNodeUtil;

class Test2 {

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode tmp = head.next.next;
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = reverse(tmp);
        return newHead;
    }

    public static void main(String[] args) {
        Test2 t2 = new Test2();
        ListNode ans = t2.reverse(ListNodeUtil.create(new int[]{1,2,3,4,5}));
        ListNodeUtil.print(ans);
    }
}
