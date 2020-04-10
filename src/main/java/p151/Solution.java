package p151;

/** 翻转字符串里的单词 */
class Solution {
  public String reverseWords(String s) {
    if (null == s || s.length() == 0) return s;
    String[] sa = s.split("\\s+");
    for (int p1 = 0, p2 = sa.length - 1; p1 < p2; ) {
      if ("".equals(sa[p1].trim())) {
        sa[p1] = "";
        p1++;
      } else if ("".equals(sa[p2].trim())) {
        sa[p2] = "";
        p2--;
      } else {
        swap(sa, p1, p2);
        p1++;
        p2--;
      }
    }

    return String.join(" ", sa).trim();
  }

  private void swap(String[] s, int p1, int p2) {
    String tmp = s[p1];
    s[p1] = s[p2];
    s[p2] = tmp;
  }
}
