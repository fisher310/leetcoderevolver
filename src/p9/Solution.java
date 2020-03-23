package p9;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int real = x;
        int num = 0;
        while (x != 0) {
            num = num * 10 + x % 10;
            x = x / 10;
        }
        return real == num;
    }
//    public boolean isPalindrome(int x) {
//        if (x < 0) {
//            return false;
//        }
//
//        String a = String.valueOf(x);
//        char[] ch = a.toCharArray();
//        for (int i = 0, j = ch.length - 1; i < j; i++, j--) {
//            if (ch[i] != ch[j]) {
//                return false;
//            }
//        }
//        return true;
//    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome(121));
        System.out.println(s.isPalindrome(-121));
        System.out.println(s.isPalindrome(10));
    }
}
