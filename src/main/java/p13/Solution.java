package p13;

/**
 * 罗马数字转整数
 */
class Solution {
    public int romanToInt(String s) {
        int i = -1;
        int ans = 0;
        while (++i < s.length()) {
            char c = s.charAt(i);
            switch (c) {
                case 'M':
                    ans += 1000;
                    break;
                case 'C':
                    if (i + 1 < s.length()) {
                        if (s.charAt(i + 1) == 'D') {
                            ans += 400;
                            i++;
                        } else if (s.charAt(i + 1) == 'M') {
                            ans += 900;
                            i++;
                        } else {
                            ans += 100;
                        }
                    } else {
                        ans += 100;
                    }
                    break;
                case 'D':
                    ans += 500;
                    break;
                case 'L':
                    ans += 50;
                    break;
                case 'X':
                    if (i + 1 < s.length()) {
                        if (s.charAt(i + 1) == 'L') {
                            ans += 40;
                            i++;
                        } else if (s.charAt(i + 1) == 'C') {
                            ans += 90;
                            i++;
                        } else {
                            ans += 10;
                        }
                    } else {
                        ans += 10;
                    }
                    break;
                case 'V':
                    ans += 5;
                    break;
                case 'I':
                    if (i + 1 < s.length()) {
                        if (s.charAt(i + 1) == 'V') {
                            ans += 4;
                            i++;
                        } else if (s.charAt(i + 1) == 'X') {
                            ans += 9;
                            i++;
                        } else {
                            ans += 1;
                        }
                    } else {
                        ans += 1;
                    }
                    break;
                default:
                    break;
            }
        }
        return ans;
    }
}
