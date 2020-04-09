package p709;

/** 转化成小写字母 */
class Solution {
  public String toLowerCase(String str) {
    if (str == null || str.length() == 0) return str;
    char[] chars = str.toCharArray();
    for (int i = 0, n = chars.length; i < n; i++) {
      if (65 <= chars[i] && chars[i] <= 90) {
        chars[i] += 32;
      }
    }
    return new String(chars);
  }
}
