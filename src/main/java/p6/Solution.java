package p6;

import java.util.ArrayList;
import java.util.List;

/**
 * Z字形变换
 */
class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        boolean goingDown = true;

        int i = 0;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0) {
                goingDown = true;
            } else if (i == numRows - 1) {
                goingDown = false;
            }
            if (goingDown) {
                i++;
            } else {
                i--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String ans = s.convert("LEETCODEISHIRING", 3);
        System.out.println(ans);
        assert ans.equals("LCIRETOESIIGEDHN");

        ans = s.convert("LEETCODEISHIRING", 4);
        System.out.println(ans);
        assert ans.equals("LDREOEIIECIHNTSG");

        ans = s.convert("AB", 1);
        assert ans.equals("AB");
    }
}
