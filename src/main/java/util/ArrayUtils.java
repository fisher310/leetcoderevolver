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

    public static int[] getInput1(String str) {
        String s = str.substring(1, str.length()-1).trim();
        if (s.length() == 0) {
            return new int[0];
        }
        String[] arr = s.split(",");
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = Integer.parseInt(arr[i]);
        }

        return res;
    }

    public static int[][] getInput2(String str) {
        String s = str.substring(1, str.length()-1).trim();
        if (s.length() == 0) {
            return new int[0][0];
        }
        s = s.replaceAll("],\\[", "]T[");

        String[] arr = s.split("T");
        int[][] res = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            res[i] = getInput1(arr[i]);
        }

        return res;
    }

}
