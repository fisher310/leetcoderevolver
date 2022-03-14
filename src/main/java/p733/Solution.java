package p733;
import java.util.*;

class Solution {
	private int[] dx = {-1, 0, 1, 0};

	private int[] dy = {0, 1, 0, -1};

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int R = image.length;
		int C = image[0].length;
		int color = image[sr][sc];
		Queue<int[]> queue = new LinkedList<>();
		image[sr][sc] = -1;
		queue.offer(new int[]{ sr, sc });
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int k = 0; k < 4; k++) {
				int x = curr[0] + dx[k];
				int y = curr[1] + dy[k];
				if (x >= 0 && x < R && y >= 0 && y < C && image[x][y] != -1 && image[x][y] == color) {
					image[x][y] = -1;
					queue.offer(new int[]{ x, y });
				}

			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (image[i][j] == -1) {
					image[i][j] = newColor;
				}
			}
		}

		return image;
    }
	public static void main(String[] args) {

		Solution s = new Solution();
	}
}
