package p523;

import java.util.HashMap;
import java.util.Map;

/**
 * <h>连续的子数组和 </h>
 *
 * <p>给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 */
class Solution {
    // 还是前缀和的思路求解
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (k != 0) {
                pre = pre % k;
            }
            if (map.containsKey(pre)) {
                if (i - map.get(pre) > 1) {
                    return true;
                }
            } else {
                map.put(pre, i);
            }
        }

        return false;
    }
}
