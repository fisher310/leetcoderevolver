package p1019;

import util.ListNode;
import util.ListNodeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 *
 * <p>每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j >
 * i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 *
 * <p>返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 *
 * <p>注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入：[2,1,5] 输出：[5,5,0] 示例 2：
 *
 * <p>输入：[2,7,4,3,5] 输出：[7,0,5,5,0] 示例 3：
 *
 * <p>输入：[1,7,5,1,9,2,5,1] 输出：[7,9,9,9,0,5,0,0]
 *
 * <p>提示：
 *
 * <p>对于链表中的每个节点，1 <= node.val <= 10^9 给定列表的长度在 [0, 10000] 范围内
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/next-greater-node-in-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

  public int[] nextLargerNodes(ListNode head) {
    List<Integer> ans = new ArrayList<>();
    LinkedList<Integer> stack = new LinkedList<>();
    ArrayList<Integer> data = new ArrayList<>();

    ListNode current = head;
    int index = 0;
    while (current != null) {
      data.add(current.val);
      ans.add(0);
      while (!stack.isEmpty() && current.val > data.get(stack.getFirst())) {
        Integer pop = stack.removeFirst();
        ans.set(pop, current.val);
      }
      stack.addFirst(index);
      index++;
      current = current.next;
    }

    return ans.stream().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) {
    //        ListNode l = ListNodeUtil.create(new int[] {2, 1, 5});
    //        ListNode l = ListNodeUtil.create(new int[] {2, 7, 4, 3, 5});
    //    ListNode l = ListNodeUtil.create(new int[] {1, 7, 5, 1, 9, 2, 5, 1});
    ListNode l = ListNodeUtil.create(new int[] {9, 7, 6, 7, 6, 9});
    Solution s = new Solution();
    int[] ans = s.nextLargerNodes(l);
    System.out.println(Arrays.toString(ans));
  }
}
