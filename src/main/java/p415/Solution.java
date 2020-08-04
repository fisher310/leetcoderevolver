package p415;

class Solution {

    public String addStrings(String num1, String num2) {

        StringBuilder ans = new StringBuilder();
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        int shift = 0;
        while (l1 >= 0 && l2 >= 0) {
            int a = num1.charAt(l1) - '0';
            int b = num2.charAt(l2) - '0';
            ans.append((a + b + shift) % 10);
            shift = (a + b + shift) / 10;
            l1--;
            l2--;
        }
        while (l1 >= 0) {
            int a = num1.charAt(l1) - '0';
            ans.append((a + shift) % 10);
            shift = (a + shift) / 10;
            l1--;
        }

        while (l2 >= 0) {
            int b = num2.charAt(l2) - '0';
            ans.append((b + shift) % 10);
            shift = (b + shift) / 10;
            l2 --;
        }
        if (shift > 0) {
            ans.append(shift);
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
