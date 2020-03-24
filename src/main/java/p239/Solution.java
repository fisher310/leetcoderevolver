package p239;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * <p>返回滑动窗口中的最大值。
 *
 * <p>
 *
 * <p>示例:
 *
 * <p>输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3 输出: [3,3,5,5,6,7] 解释:
 *
 * <p>滑动窗口的位置 最大值 <br>
 * --------------- ----- <br>
 * [1 3 -1] -3 5 3 6 7 3 <br>
 * 1 [3 -1 -3] 5 3 6 7 3 <br>
 * 1 3 [-1 -3 5] 3 6 7 5 <br>
 * 1 3 -1 [-3 5 3] 6 7 5 <br>
 * 1 3 -1 -3 [5 3 6] 7 6 <br>
 * 1 3 -1 -3 5 [3 6 7] 7 <br>
 *
 * <p>提示：
 *
 * <p>你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return new int[]{};
    }
    Deque<Integer> window = new LinkedList<>();
    //    List<Integer> result = new ArrayList<>(nums.length - k);
    int[] result = new int[nums.length - k + 1];
    for (int i = 1, n = nums.length; i <= n; i++) {
      if (i >= k && !window.isEmpty() && window.peek() <= i - k) {
        window.pop();
      }
      while (!window.isEmpty() && nums[window.peekLast() - 1] <= nums[i - 1]) {
        window.pollLast();
      }
      window.offer(i);
      if (i - k >= 0) {
        //        result.add(nums[window.peek() - 1]);
        result[i - k] = nums[window.peek() - 1];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    //    int[] input = new int[] {1, 3, -1, -3, 5, 3, 6, 7};
    //    int k = 3; // ans [3,3,5,5,6,7]
    //    int[] input = new int[] {1, -1};
    //    int k = 1; ans [1,-1]

    int[] input = new int[] {1, 3, 1, 2, 0, 5};
    int k = 3;
    Solution s = new Solution();
    System.out.println(Arrays.toString(s.maxSlidingWindow(input, k)));
  }
}
