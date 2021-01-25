package p1403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lihailong
 * @since 2021/1/14 0014
 */
class Solution {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();

        int sl = 0, sr = 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (sl >= sr) {
                sr += nums[r];
                ans.add(nums[r]);
                r--;
            } else {
                sl += nums[l];
                l++;
            }
        }

        if (sl + nums[l] >= sr) {
            ans.add(nums[l]);
        }
        return ans;
    }
}
