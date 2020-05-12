package util;

public class ListNodeUtil {

  private ListNodeUtil() {}

  public static void print(ListNode head) {
    ListNode current = head;

    while (current != null) {
      System.out.print(current.val + "->");
      current = current.next;
    }
    System.out.println("null");
  }

  public static void printArray(ListNode head, boolean inline) {
    if (inline) System.out.print(join(head));
    else System.out.println(join(head));
  }

  public static String join(ListNode head) {
    StringBuilder sb = new StringBuilder("[");
    while (head != null) {
      sb.append(head.val).append(",");
      head = head.next;
    }
    if (sb.lastIndexOf(",") > 0) sb.setLength(sb.length() - 1);
    sb.append("]");
    return sb.toString();
  }

  public static ListNode create(int[] arr) {
    if (arr.length == 0) {
      return null;
    }

    ListNode head = new ListNode(arr[0]);
    ListNode current = head;
    for (int i = 1; i < arr.length; i++) {
      current.next = new ListNode(arr[i]);
      current = current.next;
    }
    return head;
  }
}
