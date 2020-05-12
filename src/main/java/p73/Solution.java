package p73;

import java.util.HashSet;
import java.util.Set;

/** 矩阵置零 */
class Solution {

    public void setZeroes(int[][] matrix) {
        if (matrix == null) return;
        int row = matrix.length;
        int col = matrix[0].length;
        Set<Integer> r = new HashSet<>();
        Set<Integer> c = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    r.add(i);
                    c.add(j);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if ((r.contains(i) || c.contains(j)) && matrix[i][j] != 0){
                    matrix[i][j] = 0;
                }
            }
        }
//        for (int a : r) {
//            for (int k = 0; k < col; k++) {
//                matrix[a][k] = 0;
//            }
//        }
//
//        for (int b : c) {
//            for (int k = 0; k < row; k++) {
//                matrix[k][b] = 0;
//            }
//        }
    }

    public static void main(String[] args) {
        System.out.println( 1.0 / 0 > Integer.MAX_VALUE);
    }
}
