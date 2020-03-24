package p12;

/**
 * 整数转罗马数字
 */
class Solution {
    public String intToRoman(int num) {
        int thousand = num / 1000;
        num = num % 1000;
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= thousand; i++) {
            ans.append("M");
        }

        process(num / 100, ans, "CM", "CD", "D", "C");
        num = num % 100;

        process(num / 10, ans, "XC", "XL", "L", "X");
        num = num % 10;

        process(num, ans, "IX", "IV", "V", "I");
        return ans.toString();
    }

    void process(int num, StringBuilder sb, String nine, String four, String five, String one) {
        if (num == 9) {
            sb.append(nine);
            return;
        } else if (num == 4) {
            sb.append(four);
            return;
        } else if (num >= 5) {
            sb.append(five);
            num -= 5;
        }

        for (int i = 1; i <= num; i++) {
            sb.append(one);
        }
    }
}
