package p96;

/** 不同的二叉搜索树 */
class Solution {

    /**
     * G[i] = ΣG[i-1]*G[n-i]
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }

        return G[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numTrees(3));
    }
}
