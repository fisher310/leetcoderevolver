package p922;

import java.util.LinkedList;

class Solution {

    public int[] sortArrayByParityII(int[] A) {
        LinkedList<Integer> odd = new LinkedList<>();
        LinkedList<Integer> even = new LinkedList<>();

        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0 && A[i] % 2 != 0) {
                // 偶数位置出现了奇数
                if (even.isEmpty()) {
                    odd.push(i);
                } else {
                    int j = even.pop();
                    swap(A, i, j);
                }
            } else if (i % 2 != 0 && A[i] % 2 == 0) {
                // 奇数位置出现了偶数
                if (odd.isEmpty()) {
                    even.push(i);
                } else {
                    int j = odd.pop();
                    swap(A, i, j);
                }
            }
        }

        return A;
    }

    void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
