package p287;

import java.lang.reflect.WildcardType;
import java.util.Arrays;

/**
 * @author lihailong
 * @since 2021/04/19 14:23:12
 */
class Solution {

    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findDuplicate(new int[]{1, 2, 3, 2, 2}));
    }
}
