package p738;

/**
 * @author lihailong
 * @since 2020/12/15 0015
 */
class Solution {

    public int monotoneIncreasingDigits(int N) {

        char[] ch = String.valueOf(N).toCharArray();
        int f = ch.length;

        for (int i = ch.length - 1; i > 0; i--) {
            if (ch[i-1] > ch[i]) {
                f = i;
                ch[i-1]--;
            }
        }

        for (int i = f; i < ch.length; i++) {
            ch[i] = '9';
        }

        return Integer.parseInt(new String(ch));
    }
}
