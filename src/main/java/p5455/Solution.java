package p5455;

import java.util.Arrays;

class Solution {
    public String minInteger(String num, int k) {

        char[] arr = num.toCharArray();

        Arrays.sort(arr);

        System.out.println(arr);
        System.out.println(num);
        System.out.println(1342);
        return "";
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.minInteger("4321", 4);
    }
}
