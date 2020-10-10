package p1576;

class Solution {

    public String modifyString(String s) {

        char[] ch = s.toCharArray();

        int k = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '?') {
                while ((i > 0 && ('a' + k % 26) == ch[i-1])) {
                    k++;
                }

                while (i < ch.length - 1 && ('a' + k % 26 == ch[i+1])) {
                    k++;
                }

                ch[i] = (char)('a' + (k % 26));
            }
        }

        return new String(ch);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.modifyString("?zs"));
        System.out.println(s.modifyString("ubv?w"));
        System.out.println(s.modifyString("j?qg??b"));
        System.out.println(s.modifyString("??yw?ipkj?"));

    }
}
