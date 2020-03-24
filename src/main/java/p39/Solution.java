package p39;

import java.util.*;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * <p>candidates 中的数字可以无限制重复被选取。
 *
 * <p>说明：
 *
 * <p>所有数字（包括 target）都是正整数。 解集不能包含重复的组合。  示例 1:
 *
 * <p>输入: candidates = [2,3,6,7], target = 7, 所求解集为: [ [7], [2,2,3] ] 示例 2:
 *
 * <p>输入: candidates = [2,3,5], target = 8, 所求解集为: [   [2,2,2,2],   [2,3,3],   [3,5] ]
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return Collections.emptyList();
        Arrays.sort(candidates);

        dfs(new ArrayDeque<Integer>(), candidates, 0, target);
        return ans;
    }

    void dfs(Deque<Integer> num, int[] candidates, int start, int target) {

        if (target == 0) {
            ans.add(new ArrayList<>(num));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (target - candidates[i] < 0) {
                    break;
                }
                num.addLast(candidates[i]);
                dfs(num, candidates, i, target - candidates[i]);
                num.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //        List<List<Integer>> lists = s.combinationSum(new int[]{2, 3, 6, 7}, 7);
        List<List<Integer>> lists = s.combinationSum(new int[]{8, 7, 4, 3}, 11);
        System.out.println(lists);
    }
}
