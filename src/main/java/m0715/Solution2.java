package m0715;

class Solution2 {

    public int numMusicPlaylists(int N, int L, int K) {

        int M = 1000000007;
        int ans = 1;
        for (int i = 0; i < L; i++) {
            if (i < K) {
                ans = ans * (N - i) % M;
            } else {
                ans = ans * (N - K) % M;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.numMusicPlaylists(3, 3, 1));
        System.out.println(s.numMusicPlaylists(2, 3, 0));
    }
}
