package acm1.chp2;

import org.junit.Assert;

/**
 * @author lihailong
 * @since 2021-09-01 18:00:03
 */
public class UVa1585 {

  public int score(String text) {

    int ans = 0;
    int score = 1;
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      if (c == 'O') {
        ans += score;
        score++;
      } else {
        score = 1;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    UVa1585 s = new UVa1585();
    Assert.assertEquals(1+2+0+0+1+1+2+3,s.score("OOXXOXXOOO"));
  }
}
