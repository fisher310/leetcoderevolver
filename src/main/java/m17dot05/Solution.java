package m17dot05;

import static org.junit.Assert.assertArrayEquals;


class Solution {

    public String[] findLongestSubarray(String[] array) {
        int n = array.length;

        int l = 0, r = 0, max = 0;
        for (int i = 0; i < n; i++) {
            int c = 0, m = 0;
            for (int j = i; j < n; j++) {
                // i->j max j when count(char) == count(num)
                if (Character.isDigit(array[j].charAt(0))) {
                    m++;
                } else {
                    c++;
                }
                if (m == c && m > max) {
                    l = i;
                    r = j;
                    max = m;
                }
            }

        }

        if (l == r) {
            return new String[0];
        }
        String[] ans = new String[r - l + 1];
        System.arraycopy(array, l, ans, 0, r - l + 1);

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        assertArrayEquals(new String[]{"A", "1"}, s.findLongestSubarray(new String[] { "A", "A", "1" }));

        assertArrayEquals(new String[] { "A", "A", "B", "1", "2", "A", "1", "5" },
                s.findLongestSubarray(new String[] { "X", "A", "A", "B", "1", "2", "A", "1", "5", "X", "X" }));
        assertArrayEquals(new String[] {}, s.findLongestSubarray(new String[] { "A", "A" }));
    }
}
