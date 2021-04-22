package p1835;

/**
 * @author lihailong
 * @since 2021/04/21 21:04:48
 */
class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {

        int a = 0, b = 0;
        for (int i : arr1) {
            a ^= i;
        }

        for (int j : arr2) {
            b ^= j;
        }

        return a & b;
    }
}
