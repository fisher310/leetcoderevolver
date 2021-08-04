package m16dot15;

import java.util.Arrays;
import org.junit.*;

/**
 * R G B Y 

 */
class Solution {

    public int[] masterMind(String solution, String guess) {

        int a = 0, b = 0;
        boolean[] visited = new boolean[4];
        for (int i =  0; i < 4; i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                a++;
            } else {
                for (int j = 0; j < 4; j++) {
                    if (solution.charAt(j) == guess.charAt(i)
                            && solution.charAt(j) != guess.charAt(j)
                            && !visited[j]) {
                        b++;
                        visited[j] = true;
                        break;
                    }
                }
            }
        }

        return new int[] { a, b };
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.masterMind("RGBY", "GGRR")));
        System.out.println(Arrays.toString(s.masterMind("RGBY", "GGRR")));

    }
}
