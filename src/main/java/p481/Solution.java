package p481;

import org.junit.Assert;

class Solution {

    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;
        int[] arr = new int[n + 1];
        arr[0] = 2;
        arr[1] = 1;
        arr[2] = 2;
        int i = 1, j = 1, count = 0;
        while (i <= n && j <= n) {
            int t = arr[i++];
            int num = arr[j - 1] == 2 ? 1 : 2;
            while (t > 0 && j <= n) {
                arr[j++] = num;
                if (num == 1) count++;
                t--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(3, s.magicalString(6));
        Assert.assertEquals(2, s.magicalString(4));
        Assert.assertEquals(1, s.magicalString(3));
        Assert.assertEquals(1, s.magicalString(1));
        Assert.assertEquals(1, s.magicalString(2));
    }
}
