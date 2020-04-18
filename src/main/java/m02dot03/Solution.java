package m02dot03;

import util.ListNode;

/** 删除中间节点 */
class Solution {
  public void deleteNode(ListNode node) {

    ListNode next = node.next;
    node.val = next.val;
    node.next = next.next;
  }
}
