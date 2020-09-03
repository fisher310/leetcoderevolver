package p491;

import util.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 */
class Solution {

    public List<List<Integer>> findSubsequences(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums, 0, Integer.MIN_VALUE, list, res);

        return res;
    }


    private void helper(int[] nums, int curr, int pre, List<Integer> list, List<List<Integer>> res) {
        if (curr == nums.length) {
            if (list.size() > 1) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        if (nums[curr] >= pre) {
            list.add(nums[curr]);
            helper(nums, curr + 1, nums[curr], list, res);
            list.remove(list.size() - 1);
        }

        if (nums[curr] != pre) {
            helper(nums, curr + 1, pre, list, res);
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListUtil.print2(s.findSubsequences(new int[]{-100, -100, 0, 0, 0, 100, 100, 0, 0}));
//        ListUtil.print2(s.findSubsequences(new int[]{2, 1, 2, 1, 1}));
//        ListUtil.print2(s.findSubsequences(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 1}));
//        ListUtil.print2(s.findSubsequences(new int[]{4, 4, 4, 4}));
        ListUtil.print2(s.findSubsequences(new int[]{4, 6, 7, 7}));
//
//        ListUtil.print2(s.findSubsequences(new int[]{1, 4, 2, 1}));
//        ListUtil.print2(s.findSubsequences(new int[]{1, 4, 4, 3}));
//        ListUtil.print2(s.findSubsequences(new int[]{1, 4, 4, 3, 5, 7}));
//        ListUtil.print2(s.findSubsequences(new int[]{4, 3, 2, 1}));

    }
}
