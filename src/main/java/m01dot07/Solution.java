package m01dot07;

import util.ArrayUtils;

/** 旋转矩阵 */
public class Solution {
  public void rotate(int[][] matrix) {
    if (null == matrix || matrix.length == 0) return;
    int start = 0;
    int end = matrix.length - 1;
    while (start < end) {
      helper(matrix, start, end);
      start++;
      end--;
    }
  }

  void helper(int[][] matrix, int start, int end) {
    int N = end - start;
    for (int i = 0; i < N; i++) {
      int tmp = matrix[start][start + i];
      matrix[start][start + i] = matrix[end - i][start];
      matrix[end - i][start] = matrix[end][end - i];
      matrix[end][end - i] = matrix[start + i][end];
      matrix[start + i][end] = tmp;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] matrix = new int[][] {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
    s.rotate(matrix);
    ArrayUtils.print(matrix);
  }
}
