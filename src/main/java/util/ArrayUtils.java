package util;

public class ArrayUtils {

    public static void print(Object[][] matrix) {
        for (Object[] row : matrix) {
            for (Object cel : row) {
                System.out.print(cel + " ");
            }
            System.out.println();
        }
    }

    public static void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cel : row) {
                System.out.print(cel + " ");
            }
            System.out.println();
        }
    }

    public static void print(boolean[][] matrix) {
        for (boolean[] row : matrix) {
            for (boolean cel : row) {
                System.out.print(cel + "\t");
            }
            System.out.println();
        }
    }
}
