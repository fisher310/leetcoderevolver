package m0716;

class Solution2 {

    public int minDeletionSize(String[] A) {
        if (A == null || A.length == 0)
            return 0;
        int L = A[0].length();
        if (L == 0)
            return 0;
        int N = A.length;
        int ans = 0;
        outer: for (int i = 0; i < L; i++) {
            char pre = A[0].charAt(i);
            for (int j = 1; j < N; j++) {
                char curr = A[j].charAt(i);
                if (curr < pre) {
                    ans++;
                    continue outer;
                }
                pre = curr;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.minDeletionSize(new String[] { "cba", "daf", "ghi" }));
        System.out.println(s.minDeletionSize(new String[] { "rrjk", "furt", "guzm" }));
        System.out.println(s.minDeletionSize(new String[] { "zyx", "wuv", "tsr" }));
        System.out.println(s.minDeletionSize(new String[] { "a", "b" }));

    }
}