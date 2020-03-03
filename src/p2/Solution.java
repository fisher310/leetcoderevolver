package p2;

import util.ListNode;
import util.ListNodeUtil;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * <p>如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * <p>您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * <p>示例：
 *
 * <p>输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 */
public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int sum = l1.val + l2.val;
    ListNode head = new ListNode(sum % 10);
    int div = sum / 10;
    l1 = l1.next;
    l2 = l2.next;

    ListNode current = head;
    while (l1 != null) {
      if (l2 != null) {
        sum = l1.val + l2.val + div;
        div = sum / 10;
        ListNode newNode = new ListNode(sum % 10);
        current.next = newNode;
        current = newNode;
        l2 = l2.next;
      } else {
        sum = l1.val + div;
        div = sum / 10;
        ListNode newNode = new ListNode(sum % 10);
        current.next = newNode;
        current = newNode;
      }
      l1 = l1.next;
    }

    while (l2 != null) {
      sum = l2.val + div;
      div = sum / 10;
      ListNode newNode = new ListNode(sum % 10);
      current.next = newNode;
      current = newNode;
      l2 = l2.next;
    }
    if (div > 0) {
      current.next = new ListNode(div);
    }
    return head;
  }

  public static void main(String[] args) {
    int[] arr1 = new int[] {2, 4, 3};
    int[] arr2 = new int[] {5, 6, 4};

    ListNode l1 = ListNodeUtil.create(arr1);
    ListNode l2 = ListNodeUtil.create(arr2);

    ListNodeUtil.print(l1);
    ListNodeUtil.print(l2);

    ListNode l3 = new Solution().addTwoNumbers(l1, l2);
    ListNodeUtil.print(l3);
  }
}
