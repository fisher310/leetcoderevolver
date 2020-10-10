package p1356;

import org.junit.Assert;

import java.util.Arrays;

class Solution {
    public int[] sortByBits(int[] arr) {
        int[] map = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            map[i] = Integer.bitCount(arr[i]) * 1_000_0000 + arr[i];
        }
        Arrays.sort(map);

        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = map[i] % 1_000_0000;
        }
//        int N = arr.length;
//        Node[] b = new Node[N];
//
//        for (int i = 0; i < arr.length; i++) {
//            b[i] = new Node(arr[i]);
//        }
//        Arrays.sort(b, (o1, o2) -> {
//            if (o1.bits == o2.bits) {
//                return o1.val - o2.val;
//            }
//            return o1.bits - o2.bits;
//        });
//        int[] ans = new int[N];
//        for (int i = 0; i < N; i++) {
//            ans[i] = b[i].val;
//        }
//
        return ans;
    }

    private int getBits(int n) {
        int num = 0;
        while (n != 0) {
            n &= n - 1;
            num++;
        }
        return num;
    }

    private class Node {
        private int val;
        private int bits;

        Node(int _val) {
            this.val = _val;
            this.bits = getBits(this.val);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        Assert.assertArrayEquals(new int[]{0, 1, 2, 4, 8, 3, 5, 6, 7}, s.sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}));
        Assert.assertArrayEquals(
                new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024},
                s.sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1}));
    }
}
