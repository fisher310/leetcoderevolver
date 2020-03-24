package p876;

import util.ListNode;
import util.ListNodeUtil;

class Solution {
    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode list = ListNodeUtil.create(new int[]{1, 2, 3, 4, 5});
//        ListNode list = ListNodeUtil.create(new int[]{1, 2, 3, 4, 5, 6});
        Solution s = new Solution();
        System.out.println(s.middleNode(list).val);
    }
}
