package p999;

public class Solution {
    public int numRookCaptures(char[][] board) {
        int ans = 0;
        outer:
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    int left = j - 1;
                    while (left >= 0) {
                        if (board[i][left] == 'B') {
                            break;
                        } else if (board[i][left] == 'p') {
                            ans++;
                            break;
                        }
                        left--;
                    }
                    int right = j + 1;
                    while (right < 8) {
                        if (board[i][right] == 'B') {
                            break;
                        } else if (board[i][right] == 'p') {
                            ans++;
                            break;
                        }
                        right++;
                    }

                    int up = i - 1;
                    while (up >= 0) {
                        if (board[up][j] == 'B') {
                            break;
                        } else if (board[up][j] == 'p') {
                            ans++;
                            break;
                        }
                        up--;
                    }

                    int down = i + 1;
                    while (down < 8) {
                        if (board[down][j] == 'B') {
                            break;
                        } else if (board[down][j] == 'p') {
                            ans++;
                            break;
                        }
                        down++;
                    }
                    break outer;
                }
            }
        }
        return ans;
    }
}
