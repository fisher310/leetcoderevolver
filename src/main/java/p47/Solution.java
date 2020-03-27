package p47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * <p>示例:
 *
 * <p>输入: [1,1,2] 输出: [ [1,1,2], [1,2,1], [2,1,1] ]
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        if (null == nums || nums.length == 0) return Collections.emptyList();
        List<List<Integer>> ans = new ArrayList<>();
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        helper(ans, new ArrayList<>(nums.length), nums, visited);
        return ans;
    }

    void helper(List<List<Integer>> ans, List<Integer> list, int[] nums, int[] visited) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0, n = nums.length; i < n; i++) {
            if (visited[i] != 1) {
                list.add(nums[i]);
                visited[i] = 1;
                helper(ans, list, nums, visited);
                visited[i] = 0;
                list.remove(list.size() - 1);
                while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                    i++;
                }
            }
        }
    }
}
