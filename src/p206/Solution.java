package p206;

public class Solution {

  public ListNode reverseList(ListNode head) {

    ListNode pre = null, current, next;
    current = head;
    while (current != null) {
      next = current.next;
      current.next = pre;
      pre = current;
      current = next;
    }
    return pre;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode last = head;
    for (int i = 2; i < 6; i++) {
      last.next = new ListNode(i);
      last = last.next;
    }
    printNode(head);

    ListNode reverseHead = new Solution().reverseList(head);

    printNode(reverseHead);
  }

  private static void printNode(ListNode head) {
    ListNode current = head;
    while (current != null) {
      System.out.print(current.val + "->");
      current = current.next;
    }
    System.out.println("null");
  }
}
