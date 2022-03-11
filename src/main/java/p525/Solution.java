package p525;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * [0,1] -> 2
 *
 * @author lihailong
 * @since 2021/08/13 19:32:12
 */
class Solution {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int l = 0, r = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0 ? -1 : 1);
            if (map.containsKey(sum)) {
                if ((i - map.get(sum)) > (r - l)) {
                    l = map.get(sum) + 1;
                    r = i + 1;
                }
            } else {
                map.put(sum, i);
            }
        }

        return r - l;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        assertEquals(2, s.findMaxLength(new int[] {0, 1}));
        assertEquals(2, s.findMaxLength(new int[] {0, 1, 0}));
    }
}
