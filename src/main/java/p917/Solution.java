package p917;

/** 仅仅翻转字母 */
class Solution {
  public String reverseOnlyLetters(String s) {
    if (s == null || s.length() < 2) return s;
    int m = 0, n = s.length() - 1;
    char[] chars = s.toCharArray();
    for (; m < n; ) {
      boolean mIsLetter = isLetter(chars[m]);
      boolean nIsLetter = isLetter(chars[n]);
      if (mIsLetter && nIsLetter) {
        char tmp = chars[m];
        chars[m] = chars[n];
        chars[n] = tmp;
        m++;
        n--;
        continue;
      }

      if (!mIsLetter) m++;
      if (!nIsLetter) n--;
    }
    return new String(chars);
  }

  private boolean isLetter(char c) {
    return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.reverseOnlyLetters("ab-cd");
  }
}
