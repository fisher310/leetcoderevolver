package p880;

/**
 * @author lihailong
 * @since 2021/1/9 0009
 */
class Solution {

    public String decodeAtIndex(String S, int K) {
        long size = 0;
        long T = K;
        int N = S.length();

        for (int i = 0; i < N; i++) {
            char c = S.charAt(i);
            if (c >= '2' && c <= '9') {
                size *= c - '0';
            } else {
                size++;
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            char c = S.charAt(i);
            T = (T % size);
            if (T == 0 && Character.isLetter(c)) {
                return Character.toString(c);
            }

            if (Character.isDigit(c)) {
                size /= c - '0';
            } else {
                size--;
            }
        }
        return null;
    }
}
