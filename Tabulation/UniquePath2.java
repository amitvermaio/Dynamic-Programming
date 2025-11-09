import java.util.Arrays;

public class UniquePath2 {
  class Solution {
    public int uniquePathsWithObstacles(int[][] og) {
      int m = og.length;
      int n = og[0].length;
      int[][] dp = new int[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (og[i][j] == 1) {
            og[i][j] = -1;
          }
        }
      }

      for (int i = 1; i < m; i++) {
        if (og[i][0] == -1)
          break;
        dp[i][0] = 1;
      }

      for (int j = 1; j < n; j++) {
        if (og[0][j] == -1)
          break;
        dp[0][j] = 1;
      }

      for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
          if (og[i][j] == -1)
            continue;
          if (og[i - 1][j] != -1 && og[i][j - 1] != -1) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
          } else {
            dp[i][j] = og[i-1][j] != -1 ? dp[i - 1][j] : dp[i][j - 1];
          }
        }
      }
      for(int[] o : og) {
        System.out.println(Arrays.toString(o));
      }
      System.out.println("=====================");
      for (int [] row : dp) {
        System.out.println(Arrays.toString(row));
      }
      return dp[m - 1][n - 1];
    }
  }

  public static void main(String[] args) {
    int[][] og = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
    Solution sol = new UniquePath2().new Solution();
    System.out.println(sol.uniquePathsWithObstacles(og));
  }
}
