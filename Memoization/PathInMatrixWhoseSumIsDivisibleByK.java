public class PathInMatrixWhoseSumIsDivisibleByK {
  static int MOD = (int) 1e9 + 7;
  static Integer[][][] dp;

  static int dfs(int[][] grid, int i, int j, int k, int sumModK) {
    int n = grid.length, m = grid[0].length;

    if (i == n - 1 && j == m - 1) {
      int finalSum = (sumModK + grid[i][j] % k) % k;
      return finalSum == 0 ? 1 : 0;
    }

    if (i >= n || j >= m)
      return 0;

    if (dp[i][j][sumModK] != null)
      return dp[i][j][sumModK];

    int rem = grid[i][j] % k;
    int newSum = (sumModK + rem) % k;

    long ways = 0;
    ways += dfs(grid, i + 1, j, k, newSum);
    ways += dfs(grid, i, j + 1, k, newSum);
    ways %= MOD;

    return dp[i][j][sumModK] = (int) ways;
  }

  public int numberOfPaths(int[][] grid, int k) {
    int n = grid.length, m = grid[0].length;

    dp = new Integer[n][m][k];

    return dfs(grid, 0, 0, k, 0);
  }
}
