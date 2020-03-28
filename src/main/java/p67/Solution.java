package p67;

/**
 * 二进制求和 <br>
 * a = "11" b = "1" -> "100"
 */
class Solution {
    public String addBinary(String a, String b) {
        char[] ach = a.toCharArray();
        char[] bch = b.toCharArray();
        int i = ach.length - 1;
        int j = bch.length - 1;
        char shift = '0';
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            if (ach[i] == '0' && bch[j] == '0') {
                if (shift == '0') {
                    sb.append('0');
                } else {
                    sb.append('1');
                    shift = '0';
                }
            } else if (ach[i] == '1' && bch[j] == '1') {
                if (shift == '0') {
                    sb.append('0');
                    shift = '1';
                } else {
                    sb.append('1');
                }
            } else {
                if (shift == '0') {
                    sb.append('1');

                } else {
                    sb.append('0');
                }
            }
            i--;
            j--;
        }
        while (i >= 0) {
            if (shift == '0') {
                sb.append(ach[i]);
            } else {
                if (ach[i] == '0') {
                    sb.append('1');
                    shift = '0';
                } else {
                    sb.append('0');
                }
            }
            i--;
        }
        while (j >= 0) {
            if (shift == '0') {
                sb.append(bch[j]);
            } else {
                if (bch[j] == '0') {
                    sb.append('1');
                    shift = '0';
                } else {
                    sb.append('0');
                }
            }
            j--;
        }
        if (shift == '1') {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
