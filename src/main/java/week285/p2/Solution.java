package week285.p2;

public class Solution {
  public int countCollisions(String directions) {

    char[] arr = directions.toCharArray();
    int ans = arr.length;
    // if L look at left (R or S !), if R look at right (L or S !)
    int i = 0;
    for (; i < arr.length; i++) {
      if (arr[i] == 'L') {
        ans--;
      } else {
        break;
      }
    }
    int j = arr.length - 1;
    for (; j >= 0; j--) {
      if (arr[j] == 'R') {
        ans--;
      } else {
        break;
      }
    }

    for (int k = i; k <= j; k++) {
      if (arr[k] == 'S') {
        ans--;
      }
    }

    return ans;
  }
}
