package p46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * <p>示例:
 *
 * <p>输入: [1,2,3] 输出: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (null == nums || nums.length == 0) return Collections.emptyList();

        int[] visited = new int[nums.length];

        helper(new ArrayList<Integer>(nums.length), nums, nums.length, visited);

        return ans;
    }

    void helper(List<Integer> deque, int[] nums, int n, int[] visited) {
        if (deque.size() == n) {
            ans.add(new ArrayList<>(deque));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (visited[j] != 1) {
                deque.add(nums[j]);
                visited[j] = 1;
                helper(deque, nums, n, visited);
                deque.remove(deque.size() - 1);
                visited[j] = 0;
            }
        }
    }
}
