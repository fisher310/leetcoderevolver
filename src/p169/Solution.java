package p169;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0, n = nums.length; i< n; i++) {
            int v = nums[i];
            Integer old = map.put(v, map.getOrDefault(v, 0) + 1);
            if (old != null && old + 1 > n /2) {
                return v;
            }
        }
        return 0;
    }
}
