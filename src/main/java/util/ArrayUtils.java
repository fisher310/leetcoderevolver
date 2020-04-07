package util;

public class ArrayUtils {

  public static void print(int[][] matrix) {
    for (int[] row : matrix) {
      for (int cel : row) {
        System.out.print(cel + " ");
      }
      System.out.println();
    }
  }
}
