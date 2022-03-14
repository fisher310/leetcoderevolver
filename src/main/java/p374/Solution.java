package p374;

import org.junit.Assert;

/**
 * @author lihailong
 * @since 2022-02-18 10:43:21
 */
class GuessGame {
  int pickle = 6;

  int guess(int n) {
    if (n == pickle) {
      return 0;
    } else if (n < pickle) {
      return 1;
    } else {
      return -1;
    }
  }
}

public class Solution extends GuessGame {
  public int guessNumber(int n) {
    int l = 1, r = n;
    while (l < r) {
      int mid = l + (r - l) / 2;
      int res = guess(mid);
      if (res == -1) {
        // mid < pickle
        r = mid - 1;
      } else if (res == 1) {
        // mid > pickle
        l = mid + 1;
      } else {
        return mid;
      }
    }
    return l;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.pickle = 2;
    int ans = s.guessNumber(2);
    Assert.assertEquals(s.pickle, ans);
  }
}
