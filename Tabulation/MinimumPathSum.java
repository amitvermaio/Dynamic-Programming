public class MinimumPathSum {
  public static void main(String[] args) {

  }

  public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] dp = new int[m][n];
    dp[0][0] = grid[0][0];
    // Problem Statement: Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
    // Note: You can only move either down or right at any point in time.

    /*
     * Explanation:
     * sirf right or down move kar sakte hain to cost piche ka aur current cell ka sum hi hoga
     * to islie pehle 0th row and 0th column ko initialize karna padega
     * then 3rd step me dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
     * ye isliye ki hume minimum path right we jane se ya down me jaane se jisse mila utna cost aur
     * current cell ka cost add karna hai to vo new min cost hoga.
     * finally dp[m-1][n-1] will have the minimum path sum from
     */

    for (int j = 1; j < n; j++) {
      dp[0][j] = dp[0][j - 1] + grid[0][j];
    }

    for (int i = 1; i < m; i++) {
      dp[i][0] = dp[i - 1][0] + grid[i][0];
      System.out.println(dp[i][0]);
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
      }
    }
    return dp[m - 1][n - 1];
  }
}
