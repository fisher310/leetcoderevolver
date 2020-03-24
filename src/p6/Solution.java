package p6;

/**
 * Z字形变换
 */
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        char[][] matrix = new char[numRows][len];
        int r = 0, c = 0;
        boolean col = true, slash = false;
        for (char ch : s.toCharArray()) {
            matrix[r][c] = ch;
            if (col) {
                if (r == numRows - 1) {
                    col = false;
                    slash = true;
                    r--;
                    c++;
                } else {
                    r++;
                }
            } else if (slash) {
                if (r == 0) {
                    slash = false;
                    col = true;
                    r++;
                } else {
                    r--;
                    c++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char[] chars : matrix) {
            for (char ch : chars) {
                if (ch != 0) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        String ans = s.convert("LEETCODEISHIRING", 3);
//        System.out.println(ans);
//        assert ans.equals("LCIRETOESIIGEDHN");
//
//        ans = s.convert("LEETCODEISHIRING", 4);
//        assert ans.equals("LDREOEIIECIHNTSG");

        String ans = s.convert("AB", 1);
    }
}
