package p43;

class Solution {

    public String multiply(String num1, String num2) {

        StringBuilder ans = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            StringBuilder m = new StringBuilder();
            int a = num1.charAt(i) - '0';

            int shift = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int rem = (a * b + shift) % 10;
                shift = (a * b + shift) / 10;
                m.insert(0, rem);
            }
            if (shift > 0) {
                m.insert(0, shift);
            }

            for (int k = 0; k < num1.length() - 1 - i; k++) {
                m.insert(m.length(), 0);
            }

//            System.out.println(m.toString());
//            System.out.println(ans);
//            System.out.println("_____________");
            ans = add(ans, m);
        }
        int k = 0;
        for (;k < ans.length(); k++) {
            if (ans.charAt(k) != '0') {
                break;
            }
        }
        if (k == ans.length())
            return "0";

        return ans.substring(k);
    }

    StringBuilder add(StringBuilder s1, StringBuilder s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int shift = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int a = s1.charAt(i) - '0';
            int b = s2.charAt(j) - '0';
            int rem = (a + b + shift) % 10;
            shift = (a + b + shift) / 10;
            ans.insert(0, rem);
            i--;
            j--;
        }

        while (i >= 0) {
            int a = s1.charAt(i) - '0';
            int rem = (a + shift) % 10;
            shift = (a + shift) / 10;
            ans.insert(0, rem);
            i--;
        }

        while (j >= 0) {
            int b = s2.charAt(j) - '0';
            int rem = (b + shift) % 10;
            shift = (b + shift) / 10;
            ans.insert(0, rem);
            j--;
        }

        if (shift > 0) {
            ans.insert(0, shift);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.multiply("128", "0"));
        System.out.println(s.multiply("128", "256"));
    }
}
