package j208;

import org.junit.Assert;

class Solution2 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int max = Integer.MIN_VALUE;

        int rem = 0;
        int round = 0;
        int person = 0;
        int ans = 0;
        int i = 0;
        while (rem > 0 || i < customers.length) {
            if (i < customers.length) {
                rem += customers[i];
                i++;
            }
            round++;
            if (rem > 4) {
                person += 4;
                rem -= 4;
            } else {
                person += rem;
                rem = 0;
            }
            int profit = person * boardingCost - round * runningCost;
            if (profit > max) {
                max = profit;
                ans = round;
            }
        }

        return max > 0 ? ans : -1;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        Assert.assertEquals(
                993,
                s.minOperationsMaxProfit(
                        new int[] {
                            0, 43, 37, 9, 23, 35, 18, 7, 45, 3, 8, 24, 1, 6, 37, 2, 38, 15, 1, 14,
                            39, 27, 4, 25, 27, 33, 43, 8, 44, 30, 38, 40, 20, 5, 17, 27, 43, 11, 6,
                            2, 30, 49, 30, 25, 32, 3, 18, 23, 45, 43, 30, 14, 41, 17, 42, 42, 44,
                            38, 18, 26, 32, 48, 37, 5, 37, 21, 2, 9, 48, 48, 40, 45, 25, 30, 49, 41,
                            4, 48, 40, 29, 23, 17, 7, 5, 44, 23, 43, 9, 35, 26, 44, 3, 26, 16, 31,
                            11, 9, 4, 28, 49, 43, 39, 9, 39, 37, 7, 6, 7, 16, 1, 30, 2, 4, 43, 23,
                            16, 39, 5, 30, 23, 39, 29, 31, 26, 35, 15, 5, 11, 45, 44, 45, 43, 4, 24,
                            40, 7, 36, 10, 10, 18, 6, 20, 13, 11, 20, 3, 32, 49, 34, 41, 13, 11, 3,
                            13, 0, 13, 44, 48, 43, 23, 12, 23, 2
                        },
                        43,
                        54));
        Assert.assertEquals(3, s.minOperationsMaxProfit(new int[] {8, 3}, 5, 6));
        Assert.assertEquals(7, s.minOperationsMaxProfit(new int[] {10, 9, 6}, 6, 4));
        Assert.assertEquals(-1, s.minOperationsMaxProfit(new int[] {3, 4, 0, 5, 1}, 1, 92));
        Assert.assertEquals(9, s.minOperationsMaxProfit(new int[] {10, 10, 6, 4, 7}, 3, 8));
    }
}
