package p90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 子集 II
 */
class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) return Collections.emptyList();

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(0));
        ArrayList<Integer> list = new ArrayList<>();
        for (int k = 1; k <= nums.length; k++) {
            dfs(nums, 0, k, list, ans);
        }

        return ans;
    }

    private void dfs(int[] nums, int start, int k,  List<Integer> list, List<List<Integer>> ans) {
        if (k == list.size()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (start >= nums.length) return;
        int pre = nums[start];
        outer:
        for (int i = start; i < nums.length; i++) {
            while (i > start && nums[i] == pre) {
                if (++i >= nums.length)
                    break outer;
            }
            list.add(nums[i]);
            dfs(nums, i + 1, k, list, ans);
            list.remove(list.size() - 1);

            pre = nums[i];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subsetsWithDup(new int[]{1,2,2}));
        System.out.println(s.subsetsWithDup(new int[]{1,2,3}));
        System.out.println(s.subsetsWithDup(new int[]{}));
        System.out.println(s.subsetsWithDup(new int[]{1,2,2,1,1}));
    }
}
