package p541;

class Solution {
    public String reverseStr(String s, int k) {
        if (k == 1)
            return s;

        char[] arr = s.toCharArray();

        int tag = 0;
        for (int i = 0; i < arr.length; i++) {
            tag++;
            if (tag == 2 * k) {
                reverse(arr, i - 2 * k + 1, i - k);
                tag = 0;
            }
        }
        if (tag < k) {
            reverse(arr, s.length() - tag, s.length() - 1);
        } else {
            reverse(arr, s.length() - tag, s.length() - tag + k - 1);
        }

        return new String(arr);
    }

    void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseStr("abcdefg", 2));
        System.out.println(s.reverseStr("abcd", 2));
        System.out.println(s.reverseStr("abcdefghijk", 3));
    }
}
