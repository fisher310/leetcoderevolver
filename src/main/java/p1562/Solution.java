package p1562;

import org.junit.Assert;

import java.util.Map;
import java.util.TreeMap;

class Solution {

    public int findLatestStep(int[] arr, int m) {
        if (arr.length == m) return m;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, arr.length + 1);
        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = arr[i];
            Map.Entry<Integer, Integer> e = map.floorEntry(pos);

            int key = e.getKey();
            int value = e.getValue();

            if (pos - key - 1 == m) {
                return i;
            }
            if (value - pos - 1 == m) {
                return i;
            }
            map.put(key, pos);
            map.put(pos, value);
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        Assert.assertEquals(1, s.findLatestStep(new int[]{4, 3, 2, 1}, 1));
        Assert.assertEquals(4, s.findLatestStep(new int[]{3, 1, 5, 4, 2}, 1));
        Assert.assertEquals(-1, s.findLatestStep(new int[]{3, 1, 5, 4, 2}, 2));
        Assert.assertEquals(1, s.findLatestStep(new int[]{1}, 1));
        Assert.assertEquals(2, s.findLatestStep(new int[]{2, 1}, 2));
    }
}
