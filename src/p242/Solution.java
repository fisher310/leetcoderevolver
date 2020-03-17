package p242;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * <p>示例 1:
 *
 * <p>输入: s = "anagram", t = "nagaram" 输出: true 示例 2:
 *
 * <p>输入: s = "rat", t = "car" 输出: false 说明: 你可以假设字符串只包含小写字母。
 *
 * <p>进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

  public boolean isAnagram(String s, String t) {
    Map<Character, Integer> ms = new HashMap<>();
    Map<Character, Integer> mt = new HashMap<>();
    for (int i = 0, n = s.length(); i < n; i++) {
      char c = s.charAt(i);
      ms.put(c, ms.getOrDefault(c, 0) + 1);
    }
    for (int i = 0, n = t.length(); i < n; i++) {
      char c = t.charAt(i);
      mt.put(c, mt.getOrDefault(c, 0) + 1);
    }

    if (ms.size() != mt.size()) {
      return false;
    }

    for (Map.Entry<Character, Integer> e : ms.entrySet()) {
      if (!e.getValue().equals(mt.get(e.getKey()))) {
        return false;
      }
    }
    return true;
  }
}
