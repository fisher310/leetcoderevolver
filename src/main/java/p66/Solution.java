package p66;

/**
 *
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        int d = 0;
        while (i >= 0) {
            d = digits[i] + 1;
            if (d / 10 == 0) {
                digits[i] = d;
                break;
            }
            digits[i] = 0;
            i--;
        }
        if (i < 0 && d == 10) {
            int[] digits2 = new int[digits.length + 1];
            System.arraycopy(digits, 0, digits2, 1, digits.length);
            digits2[0] = 1;
            digits2[1] = 0;
            return digits2;
        }
        return digits;
    }
}
