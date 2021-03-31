package p1759;

/**
 * abbcccaa -> 13
 *
 * @author lihailong
 * @since 2021-03-30 20:54:20
 */
class Solution {

    private static final int N = 1_000_000_000 + 7;

    public int countHomogenous(String s) {

        int count = 1;
        int pre = s.charAt(0);
        long sum = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == pre) {
                count++;
            } else {
                sum = (sum + count(count)) % N;
                count = 1;
                pre = c;
            }
        }

        sum = (sum + count(count)) % N;

        return (int) sum;
    }

    long count(long n) {
        return n * (n + 1) / 2;
    }
}
