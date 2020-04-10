package p345;

/** 反转字符串中的元音字母 */
class Solution {

  private final char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
  public String reverseVowels(String s) {
    char[] arr = s.toCharArray();
    for (int i = 0, j = arr.length - 1; i < j; ) {
      if (!isVowels(arr[i])) {
        i++;
      } else if (!isVowels(arr[j])) {
        j--;
      } else {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        i++;
        j--;
      }
    }

    return new String(arr);
  }

  private boolean isVowels(char c) {
      for (int i = 0; i < 10; i++) {
        if (vowels[i] == c) {
          return true;
        }
      }
      return false;
  }
}
