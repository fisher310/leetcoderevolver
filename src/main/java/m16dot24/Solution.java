package m16dot24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> pairSums(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int s = nums[l] + nums[r];
            if (s == target) {
                ans.add(Arrays.asList(nums[l++], nums[r--]));
            } else if (s < target) {
                l++;
            } else {
                r--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.pairSums(new int[] {5, 1, 8, 4, 8, 2, 0, 5, 0, 7}, 7));
        System.out.println(s.pairSums(new int[] {5, 6, 5}, 11));
        System.out.println(s.pairSums(new int[] {5, 6, 5, 6}, 11));
    }
}
