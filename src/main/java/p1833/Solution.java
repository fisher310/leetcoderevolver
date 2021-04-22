package p1833;

import java.util.Arrays;

/**
 * @author lihailong
 * @since 2021/04/20 14:14:10
 */
class Solution {

    public int maxIceCream(int[] costs, int coins) {
        int ans = 0;
        Arrays.sort(costs);

        for (int cost : costs) {
            if (cost <= coins) {
                ans++;
                coins -= cost;
            } else {
                break;
            }
        }
        return ans;
    }
}
