package p1828;

/**
 * @author lihailong
 * @since 2021/04/21 21:32:52
 */
class Solution {

    public int[] countPoints(int[][] points, int[][] queries) {

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] c = queries[i];
            for (int[] p : points) {
                int a = p[0] - c[0];
                int b = p[1] - c[1];
                int dis = a * a + b * b;
                if (dis <= c[2] * c[2]) {
                    ans[i] += 1;
                }
            }
        }

        return ans;
    }
}
