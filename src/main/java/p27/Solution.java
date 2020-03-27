package p27;

import java.util.Arrays;

class Solution {
    public int removeElement(int[] nums, int val) {
        int p = 0;
        for (int i = 0, n = nums.length; i < n; i++) {
            if (nums[i] != val) {
                if (i != p) nums[p] = nums[i];
                p++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return p;
    }
}
