package p52;

public class Solution {
  //    Set<Integer> colSet = new HashSet<>();
  //    Set<Integer> slahSet = new HashSet<>();
  //    Set<Integer> backSlashSet = new HashSet<>();
  int ans = 0;

  public static void main(final String[] args) {
    final Solution s = new Solution();
    final long start = System.currentTimeMillis();
    System.out.println(s.totalNQueens(18));
    System.out.println(System.currentTimeMillis() - start);
  }

  public int totalNQueens(final int n) {
    //        dfs(0, n);
    dfs(n, 0, 0, 0, 0);
    return ans;
  }

  //    void dfs(int row, int n) {
  //        if (row >= n) {
  //            ans++;
  //            return;
  //        }
  //        for (int col = 0; col < n; col++) {
  //            if (colSet.contains(col) || slahSet.contains(row + col) || backSlashSet.contains(row
  // - col)) {
  //                continue;
  //            }
  //            colSet.add(col);
  //            slahSet.add(row + col);
  //            backSlashSet.add(row - col);
  //            dfs(row + 1, n);
  //            colSet.remove(col);
  //            slahSet.remove(row + col);
  //            backSlashSet.remove(row - col);
  //        }
  //    }

  void dfs(final int n, final int row, final int col, final int slash, final int backSlash) {
    if (row >= n) {
      ans++;
      return;
    }

    int bits = (~(col | slash | backSlash)) & ((1 << n) - 1);
    while (bits > 0) {
      final int p = bits & (-bits);
      dfs(n, row + 1, col | p, (slash | p) << 1, (backSlash | p) >> 1);
      bits &= bits - 1;
    }
  }
}
