package p385;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lihailong
 * @since 2022-02-21 11:19:14
 */
class NestedInteger {
  // Constructor initializes an empty nested list.
  private Integer value;
  List<NestedInteger> nested;

  public NestedInteger() {}

  // Constructor initializes a single integer.
  public NestedInteger(int value) {
    this.value = value;
  }

  // @return true if this NestedInteger holds a single integer, rather than a
  // nested list.
  public boolean isInteger() {
    return value != null;
  }

  // @return the single integer that this NestedInteger holds, if it holds a
  // single integer
  // Return null if this NestedInteger holds a nested list
  public Integer getInteger() {
    return this.value;
  }

  // Set this NestedInteger to hold a single integer.
  public void setInteger(int value) {
    this.value = value;
  }

  // Set this NestedInteger to hold a nested list and adds a nested integer to it.
  public void add(NestedInteger ni) {
    if (this.nested == null) {
      this.nested = new ArrayList<>();
    }
    this.nested.add(ni);
  }

  // @return the nested list that this NestedInteger holds, if it holds a nested
  // list
  // Return empty list if this NestedInteger holds a single integer
  public List<NestedInteger> getList() {
    return this.nested;
  }
}

class Solution {
  public NestedInteger deserialize(String s) {
    NestedInteger ans = new NestedInteger();
    int start = s.charAt(0) == '[' ? 1 : 0;
    dfs(s, start, ans);
    return ans;
  }

  int dfs(String s, int k, NestedInteger ans) {

    boolean minus = false;
    StringBuilder sb = new StringBuilder();
    int i = k;
    for (; i < s.length(); ) {
      char ch = s.charAt(i);
      if (ch == '[') {
        // 这里就是要进入list了
        NestedInteger next = new NestedInteger();
        i = dfs(s, i + 1, next);
        ans.add(next);
      } else if (ch == ']') {
        if (sb.length() > 0) {
          ans.add(new NestedInteger((minus ? -1 : 1) * Integer.parseInt(sb.toString())));
        }
        return i;
      } else if (ch == ',') {
        if (sb.length() > 0) {
          ans.add(new NestedInteger((minus ? -1 : 1) * Integer.parseInt(sb.toString())));
          sb.setLength(0);
          minus = false;
        }
      } else if (ch == '-') {
        minus = true;
      } else if (ch >= '0' && ch <= '9') {
        sb.append(ch);
      }
      i++;
    }
    if (sb.length() > 0) {
      ans.setInteger((minus ? -1 : 1) * Integer.parseInt(sb.toString()));
    }

    return i;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    NestedInteger ans = null;
    ans = s.deserialize("[123,[456,[789]]]");
    ans = s.deserialize("[123,456,[788,799,833],[[]],10,[]]");
    ans = s.deserialize("234");
  }

  private static String print(NestedInteger value) {
    return null;
  }
}
