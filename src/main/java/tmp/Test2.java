package tmp;

import util.ListNode;
import util.ListNodeUtil;

/**
 * @author lihailong
 * @since 2020/12/7 0007
 */
class Test2 {

    public ListNode deleteDuplicated(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val != head.next.val) {
            head.next = deleteDuplicated(head.next);
            return head;
        } else {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicated(head.next);
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.create(new int[] {1, 2, 2, 3, 4, 4});
        Test2 t = new Test2();
        ListNode n = t.deleteDuplicated(head);
        ListNodeUtil.print(n);
    }
}
