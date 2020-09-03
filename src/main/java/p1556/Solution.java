package p1556;

class Solution {

    public String thousandSeparator(int n) {
        if (n == 0) return "0";
        char[] ch = String.valueOf(n).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = ch.length - 1, j = 0; i >= 0; i--) {
            sb.append(ch[i]);
            j++;
            if (j == 3) {
                sb.append('.');
                j = 0;
            }
        }
        if (sb.charAt(sb.length() - 1) == '.') sb.setLength(sb.length() - 1);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.thousandSeparator(123456789));
        System.out.println(s.thousandSeparator(12345689));
    }
}
