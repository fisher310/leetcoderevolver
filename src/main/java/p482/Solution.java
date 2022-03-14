package p482;

class Solution {

    public String licenseKeyFormatting(String s, int k) {

        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1, j = 0; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '-') {
                continue;
            }
            sb.append(ch);
            j++;
            if (j % k == 0) {
                sb.append('-');
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.setLength(sb.length() - 1);
        }

        return sb.reverse().toString().toUpperCase();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String ans = s.licenseKeyFormatting("2-5g-3-j", 2);
        System.out.println(ans);
    }

}
