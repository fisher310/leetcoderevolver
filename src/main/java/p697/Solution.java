package p697;

import java.util.*;

import org.junit.Assert;

class Solution {

    public int findShortestSubArray(int[] nums) {

        Map<Integer, int[]> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int max_degree = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] data;
            if (map.containsKey(nums[i])) {
                data = map.get(nums[i]);
                data[0]++;
                data[2] = i;
                map.put(nums[i], data);
            } else {
                data = new int[3];
                data[0] = 1;
                data[1] = i;
                data[2] = i;
                map.put(nums[i], data);
            }
            if (data[0] > max_degree) {
                list.clear();
                list.add(nums[i]);
                max_degree = data[0];
            } else if (data[0] == max_degree) {
                list.add(nums[i]);
            }
        }

        int res = Integer.MAX_VALUE;

        for (int x : list) {
            int[] data = map.get(x);
            res = Math.min(res, data[2] - data[1] + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(1, s.findShortestSubArray(new int[] { 1, 2 }));
        Assert.assertEquals(2, s.findShortestSubArray(new int[] { 1, 2, 2, 3, 4, 1 }));
    }

}
