package m17dot05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;

class Solution {

    public String[] findLongestSubarray(String[] array) {
        int n = array.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            boolean isDigit = Character.isDigit(array[i].charAt(0));
            sum += (isDigit ? 1 : -1);
            if (map.containsKey(sum)) {
                if ((i - map.get(sum)) > (r - l)) {
                    l = map.get(sum) + 1;
                    r = i + 1;
                }
            } else {
                map.put(sum, i);
            }
        }

        return Arrays.copyOfRange(array, l, r);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        assertArrayEquals(
                new String[] {"A", "1"}, s.findLongestSubarray(new String[] {"A", "A", "1"}));

        assertArrayEquals(
                new String[] {"A", "A", "B", "1", "2", "A", "1", "5"},
                s.findLongestSubarray(
                        new String[] {"X", "A", "A", "B", "1", "2", "A", "1", "5", "X", "X"}));
        assertArrayEquals(new String[] {}, s.findLongestSubarray(new String[] {"A", "A"}));
    }
}
