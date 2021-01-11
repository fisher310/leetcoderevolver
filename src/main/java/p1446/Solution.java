package p1446;

/**
 * @author lihailong
 * @since 2021/1/9 0009
 */
class Solution {
    public int maxPower(String s) {
        if (s == null || s.length() == 0) return 0;
        int power = 0;
        char pre = 0;
        char count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == pre) {
                count++;
            } else {
                power = Math.max(power, count);
                pre = c;
                count = 1;
            }
        }

        power = Math.max(power, count);
        return power;
    }
}
