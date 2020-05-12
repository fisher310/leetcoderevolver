package m10dot01;

import java.util.Arrays;

/**
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * <p>初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * <p>示例:
 *
 * <p>输入: A = [1,2,3,0,0,0], m = 3 B = [2,5,6], n = 3
 *
 * <p>输出: [1,2,2,3,5,6]
 */
class Solution {
  public void merge(int[] A, int m, int[] B, int n) {
    int pa = 0, pb = 0;
    while (pb < n) {
      if (B[pb] < A[pa]) {
        for (int j = m - 1; j >= pa; j--) {
          A[j + 1] = A[j];
        }
        A[pa] = B[pb];
        m = m + 1;
        pb++;
        pa++;
      } else if (pa > m - 1){
        A[pa] = B[pb];
        pa++;
        pb++;
      } else {
        pa++;
      }
    }
  }

  public static void main(String[] args) {
    int[] A = new int[] {1, 2, 3, 0, 0, 0};
    int[] B = new int[] {2, 5, 6};
    new Solution().merge(A, 3, B, 3);
    System.out.println(Arrays.toString(A));
  }
}
