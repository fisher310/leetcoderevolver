package p190;

class Solution {

    public int reverseBits(int n) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            ans |= (n << i) >>> 31 << i;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Integer.toBinaryString(100));
        System.out.printf("%32s", Integer.toBinaryString(s.reverseBits(100)));
    }
}
