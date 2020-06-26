package p58;

/** */
class Solution {
    public int lengthOfLastWord(String s) {
        if (null == s || s.length() == 0) return 0;
        s = s.trim();

        return s.length() - s.lastIndexOf(' ') - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLastWord("hello world"));
        System.out.println(s.lengthOfLastWord("hello"));
        System.out.println(s.lengthOfLastWord("a "));
    }
}
