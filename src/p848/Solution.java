package p848;

/**
 * 有一个由小写字母组成的字符串 S，和一个整数数组 shifts。
 *
 * <p>我们将字母表中的下一个字母称为原字母的 移位（由于字母表是环绕的， 'z' 将会变成 'a'）。
 *
 * <p>例如·，shift('a') = 'b'， shift('t') = 'u',， 以及 shift('z') = 'a'。
 *
 * <p>对于每个 shifts[i] = x ， 我们会将 S 中的前 i+1 个字母移位 x 次。
 *
 * <p>返回将所有这些移位都应用到 S 后最终得到的字符串。
 *
 * <p>示例：
 *
 * <p>输入：S = "abc", shifts = [3,5,9] 输出："rpl" 解释： 我们以 "abc" 开始。 将 S 中的第 1 个字母移位 3 次后，我们得到 "dbc"。 再将
 * S 中的前 2 个字母移位 5 次后，我们得到 "igc"。 最后将 S 中的这 3 个字母移位 9 次后，我们得到答案 "rpl"。 提示：
 *
 * <p>1 <= S.length = shifts.length <= 20000 0 <= shifts[i] <= 10 ^ 9
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/shifting-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

  public String shiftingLetters(String S, int[] shifts) {
    if (S == null || S.length() == 0) return "";
    int sum = 0;
    char[] after = new char[S.length()];
    for (int i = S.length() - 1; i >= 0; i--) {
      sum = (sum + shifts[i]) % 26;
      int s1 = S.charAt(i) + sum;
      s1 = s1 > 'z' ? s1 - 26 : s1;
      after[i] = (char) s1;
    }
    return new String(after);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    //    System.out.println(s.shiftingLetters("abc", new int[] {3, 5, 9}));
    //    System.out.println(s.shiftingLetters("ruu", new int[] {26, 9, 17}));
    String input = "mkgfzkkuxownxvfvxasy";
    int[] shifts =
        new int[] {
          505870226, 437526072, 266740649, 224336793, 532917782, 311122363, 567754492, 595798950,
          81520022, 684110326, 137742843, 275267355, 856903962, 148291585, 919054234, 467541837,
          622939912, 116899933, 983296461, 536563513
        };
    System.out.println(s.shiftingLetters(input, shifts));
  }
}
