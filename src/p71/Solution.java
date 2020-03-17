package p71;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 简化路径 <br>
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 *
 * <p>在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux
 * / Unix中的绝对路径 vs 相对路径
 *
 * <p>请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/simplify-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

  public String simplifyPath(String path) {
    if (path == null || path.length() == 0) {
      return "";
    }
    LinkedList<String> stack = new LinkedList<>();
    String[] strs = path.split("/");
    for (String s : strs) {
      switch (s) {
        case "":
        case ".":
          break;
        case "..":
          if (stack.isEmpty()) {
            continue;
          }
          stack.removeFirst();
          break;
        default:
          stack.addFirst(s);
      }
    }
    if (stack.isEmpty()) {
      return "/";
    }
    StringBuilder sb = new StringBuilder("");
    while (!stack.isEmpty()) {
      sb.append("/");
      sb.append(stack.removeLast());
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    //            String path = "/home/";
    //        String path = "/../";
    //        String path = "/home//foo/";
    //        String path = "/a/../../b/../c//.//";
    //        String path = "/a/./b/../../c/";
    //        String path = "/a//b////c/d//././/..";
    //    String path = "/..";
    //    String path = "/a/./b/../../c/";
    // String path = "/..hidden";
    Map<String, String> tests = new HashMap<>();
    tests.put("/home/", "/home");
    tests.put("/../", "/");
    tests.put("/home//foo/", "/home/foo");
    //    tests.put("/a/../../b/../c//.//", "/a/c");
    tests.put("/a/./b/../../c/", "/c");
    tests.put("/a//b////c/d//././/..", "/a/b/c");
    Solution s = new Solution();
    for (Map.Entry<String, String> entry : tests.entrySet()) {
      String actual = s.simplifyPath(entry.getKey());
      if (!entry.getValue().equals(actual)) {
        System.err.println(
            String.format(
                "input [%s], expected [%s], but get [%s]",
                entry.getKey(), entry.getValue(), actual));
      } else {
        System.out.println(String.format("input [%s] test is ok", entry.getKey()));
      }
    }
  }
}
