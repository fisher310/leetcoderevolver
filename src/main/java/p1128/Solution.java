package p1128;

/**
 * @author lihailong
 * @since 2021/1/26 0026
 */
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {

        int[][] map = new int[10][10];

        int ans = 0;
        for (int[] d : dominoes) {
            int a = d[0];
            int b = d[1];

            ans += map[a][b];
            if (a != b) {
                ans += map[b][a];
            }

            map[a][b] += 1;
        }

        return ans;
    }
}
