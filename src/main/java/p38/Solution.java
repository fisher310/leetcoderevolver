package p38;

/** 外观数列 */
class Solution {
    public String countAndSay(int n) {

        String say = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char pre = say.charAt(0);
            int count = 1;
            for (int j = 1; j < say.length(); j++) {
                char c = say.charAt(j);
                if (c == pre) {
                    count++;
                } else {
                    sb.append(count).append(pre);
                    pre = c;
                    count = 1;
                }
            }
            say = sb.append(count).append(pre).toString();
        }

        return say;
    }
}
