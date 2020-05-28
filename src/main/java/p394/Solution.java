package p394;

/**
 * s = "3[a]2[bc]", 返回 "aaabcbc". <br>
 * s = "3[a2[c]]", 返回 "accaccacc". <br>
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef". <br>
 */
class Solution {

    private int pos ;

    public String decodeString(String s) {
        char[] chars = s.toCharArray();

        pos = 0;
        return dfs(chars, 0);
    }

    private String dfs(char[] array, int start) {
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < array.length;) {
            if ('0' <= array[i] && array[i] <= '9') {
                num = num * 10 + array[i] - '0';
                i++;
            } else if (array[i] == '[') {
                String s = dfs(array, i + 1);
                for (int k = num; k > 0; k--) {
                    sb.append(s);
                }
                num = 0;
                i = pos;
            } else if (array[i] == ']') {
                if (start == 0) {
                    continue;
                }
                pos = i + 1;
                return sb.toString();
            } else {
                sb.append(array[i]);
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.decodeString("100[leetcode]"));
    }
}
