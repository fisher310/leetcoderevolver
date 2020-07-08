package m16dot24;

import java.util.*;

class Solution {

    public List<List<Integer>> pairSums(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (map.containsKey(val)) {
                ans.add(Arrays.asList(val, nums[i]));
                if (map.get(val) == 1) {
                    map.remove(val);
                } else {
                    map.put(val, map.get(val) - 1);
                }
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }

        return ans;
    }
}
