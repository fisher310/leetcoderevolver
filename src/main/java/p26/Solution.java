package p26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        int j = 0;
        Integer pre = null;
        for (int i = 0; i < nums.length; i++) {
            if (pre == null || nums[i] != pre) {
                nums[j] = nums[i];
                j++;
                pre = nums[i];
            }
        }
        return j;
    }
}
