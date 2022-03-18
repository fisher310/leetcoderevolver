package p832;

public class Solution {
  public int[][] flipAndInvertImage(int[][] image) {

    for (int i = 0; i < image.length; i++) {
      help(image[i]);
    }

    return image;
  }

  void help(int[] arr) {
    int l = 0, r = arr.length - 1;
    while (l < r) {
      int tmp = arr[l];
      arr[l] = arr[r] == 1 ? 0 : 1;
      arr[r] = tmp == 1 ? 0 : 1;
    }
    if (l == r) {
        arr[l] = arr[l] == 1 ? 0 : 1;
    }
  }

  public static void main(String[] args) {
       
    
  }
}
