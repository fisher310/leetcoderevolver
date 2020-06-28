package p90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** 子集 II */
class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) return Collections.emptyList();

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        dfs(nums, 0, list, ans);

        return ans;
    }

    private void dfs(int[] nums, int start, List<Integer> list, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(list));
        if (start >= nums.length) return;
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subsetsWithDup(new int[] {1, 2, 2}));
        System.out.println(s.subsetsWithDup(new int[] {1, 2, 3}));
        System.out.println(s.subsetsWithDup(new int[] {}));
        System.out.println(s.subsetsWithDup(new int[] {1, 2, 2, 1, 1}));
    }
}
