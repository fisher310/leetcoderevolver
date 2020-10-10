package p1592;

class Solution {
    public String reorderSpaces(String text) {
        String[] words = text.trim().split("\\s+");
        int spaces = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                spaces++;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (words.length == 1) {
            sb.append(words[0]);
            while (spaces > 0) {
                sb.append(' ');
                spaces--;
            }
            return sb.toString();
        }
        int avg = spaces / (words.length - 1);
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            for (int j = 0; j < avg && spaces > 0; j++, spaces--) {
                sb.append(' ');
            }
        }

        for (int i = 0; i < spaces; i++) {
            sb.append(' ');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String ans = s.reorderSpaces("  this   is  a sentence ");
        System.out.println(ans);
    }
}
