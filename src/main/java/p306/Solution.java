package p306;

/** 累加数 */
class Solution {

    public boolean isAdditiveNumber(String num) {

        if (num == null || num.length() < 3) return false;

        // 第一个数字取i位
        long first;
        long second;
        for (int i = 1; i < num.length(); i++) {
            String s1 = num.substring(0, i);
            if (s1.startsWith("0") && s1.length() > 1) {
                continue;
            }
            first = Long.parseLong(s1);
            for (int j = 1; j < num.length() - i; j++) {
                String s2 = num.substring(i, j + i);
                if (s2.startsWith("0") && s2.length() > 1) {
                    continue;
                }
                second = Long.parseLong(s2);
                if (isValid(num, first, second, i + j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isValid(String num, long first, long second, int start) {
        long third = (first + second);
        String s = String.valueOf(third);
        int endIndex = start + s.length();
        if (endIndex > num.length()) {
            return false;
        }

        String act = num.substring(start, endIndex);
        if (!s.equals(act)) {
            return false;
        } else if (endIndex == num.length()) {
            return true;
        }

        return isValid(num, second, third, endIndex);
    }
}
