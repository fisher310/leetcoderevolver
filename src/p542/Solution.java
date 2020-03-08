package p542;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * <p>两个相邻元素间的距离为 1 。
 *
 * <p>示例 1: 输入:
 *
 * <p>0 0 0 <br>
 * 0 1 0 <br>
 * 0 0 0 输出:
 *
 * <p>0 0 0 <br>
 * 0 1 0 <br>
 * 0 0 0 示例 2: 输入:
 *
 * <p>0 0 0 <br>
 * 0 1 0 <br>
 * 1 1 1 输出:
 *
 * <p>0 0 0 <br>
 * 0 1 0 <br>
 * 1 2 1 注意:
 *
 * <p>给定矩阵的元素个数不超过 10000。 给定矩阵中至少有一个元素是 0。 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/01-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
  private Queue<Node> queue;

  public Solution() {
    queue = new LinkedList<>();
  }

  public int[][] updateMatrix(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] ans = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int value = matrix[i][j];
        if (value == 0) {
          ans[i][j] = 0;
          continue;
        }
        // 这个时候 value 的值是 1, 找他的四个方向，放入到队列当中，进行广度有限的遍历
        queue.clear();
        offerQueue(matrix, i, j, 0, queue);
        while (!queue.isEmpty()) {
          Node node = queue.poll();
          if (node.val == 0) {
            ans[i][j] = node.path;
            break;
          }
          offerQueue(matrix, node.i, node.j, node.path, queue);
        }
      }
    }

    return ans;
  }

  private void offerQueue(int[][] matrix, int i, int j, int path, Queue<Node> queue) {
    if (i - 1 >= 0) {
      queue.offer(new Node(i - 1, j, matrix[i - 1][j], path + 1));
    }
    if (i + 1 < matrix.length) {
      queue.offer(new Node(i + 1, j, matrix[i + 1][j], path + 1));
    }
    if (j - 1 >= 0) {
      queue.offer(new Node(i, j - 1, matrix[i][j - 1], path + 1));
    }
    if (j + 1 < matrix[0].length) {
      queue.offer(new Node(i, j + 1, matrix[i][j + 1], path + 1));
    }
  }

  class Node {
    int val;
    int path;
    int i;
    int j;

    Node(int i, int j, int val, int path) {
      this.i = i;
      this.j = j;
      this.val = val;
      this.path = path;
    }
  }

  public static void main(String[] args) {
//    int[][] input = new int[][] {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
    int[][] input = new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

    Solution s = new Solution();
    int[][] ans = s.updateMatrix(input);
    for (int[] row : ans) {
      for (int v : row) {
        System.out.print(v + " ");
      }
      System.out.println();
    }
  }
}
