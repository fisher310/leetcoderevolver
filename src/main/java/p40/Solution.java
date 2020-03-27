package p40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * <p>candidates 中的每个数字在每个组合中只能使用一次。
 *
 * <p>说明：
 *
 * <p>所有数字（包括目标数）都是正整数。 解集不能包含重复的组合。  示例 1:
 *
 * <p>输入: candidates = [10,1,2,7,6,1,5], target = 8, 所求解集为: [ [1, 7], [1, 2, 5], [2, 6], [1, 1, 6] ]
 * 示例 2:
 *
 * <p>输入: candidates = [2,5,2,1,2], target = 5, 所求解集为: [   [1,2,2],   [5] ]
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return Collections.emptyList();

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(ans, new ArrayList<Integer>(), -1, candidates, 0, target);
        return ans;
    }

    void helper(List<List<Integer>> ans, List<Integer> list, int i, int[] candidates, int sum, int target) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            ans.add(new ArrayList<>(list));
        }
        for (int j = i + 1; j < candidates.length; j++) {
            list.add(candidates[j]);
            sum += candidates[j];
            helper(ans, list, j, candidates, sum, target);
            list.remove(list.size() - 1);
            sum -= candidates[j];
            while (j < candidates.length - 1 && candidates[j + 1] == candidates[j]) {
                j++;
            }
        }
    }
}
