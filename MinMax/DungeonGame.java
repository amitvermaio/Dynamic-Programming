import java.util.*;

public class DungeonGame {
  public static void main(String[] args) {
    Solution sol = new Solution();
    int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
    System.out.println(sol.calculateMinimumHP(dungeon));
  }
}

// Brute Force with Binary Search + dfs
class Solution {
  static int m;
  static int n;
  HashMap<String, Boolean> mp;

  public boolean canSurvive(int mid, int i, int j, int[][] dungeon) {
    if (i >= m || j >= n)
      return false;
    mid += dungeon[i][j];
    if (mid <= 0)
      return false;
    if (i == m - 1 && j == n - 1)
      return true;

    String key = i + "_" + j + "_" + mid;
    if (mp.containsKey(key)) {
      return mp.get(key);
    }
    boolean right = canSurvive(mid, i, j + 1, dungeon);
    boolean down = canSurvive(mid, i + 1, j, dungeon);
    mp.put(key, right || down);
    return right || down;
  }

  public int calculateMinimumHP(int[][] dungeon) {
    m = dungeon.length;
    n = dungeon[0].length;
    mp = new HashMap<>();
    int left = 1;
    int right = 4 * 10_000_000;
    int res = 0;
    // 200 * 200 * 1000 as given in contraints
    // Its time complexity is O(m * n * right * log(right))
    // Space complexity is O(m * n * right)
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (canSurvive(mid, 0, 0, dungeon)) {
        res = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return res;
  }

  public int calculateMinimumHP_DP(int[][] dungeon) {
    int m = dungeon.length;
    int n = dungeon[0].length;
    int[][] dp = new int[m + 1][n + 1];

    for (int[] row : dp) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }
    dp[m][n - 1] = 1;
    dp[m - 1][n] = 1;

    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        int need = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
        dp[i][j] = need <= 0 ? 1 : need;
      }
    }
    return dp[0][0];
  }
}

class Solution2 {
  static int max_health = 4 * 1_000_0000;
  static int[][] dp;
  int m, n;

  public int topDown(int[][] dungeon, int i, int j) {
    if (i == m - 1 && j == n - 1) {
      if (dungeon[i][j] <= 0) {
        return -(dungeon[i][j] - 1);
      }
      return 1;
    }

    if (i >= m || j >= n)
      return max_health + 1;
    if (dp[i][j] != -1)
      return dp[i][j];
    int right = topDown(dungeon, i, j + 1);
    int down = topDown(dungeon, i + 1, j);
    int res = Math.min(right, down) - dungeon[i][j]; // minimum requirements jo ki piche wale ke paas honi chahiye curr
                                                     // pe aane ke liye;
    return dp[i][j] = res <= 0 ? 1 : res; // agar value requiremnt se badi already available hai eg req = 5 &
                                          // dungeon[i][j]=30 then no need to get 5 from prev element our work also been
                                          // done just by value 1;
  }

  public int calculateMinimumHP(int[][] dungeon) {
    m = dungeon.length;
    n = dungeon[0].length;
    dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        dp[i][j] = -1;
      }
    }
    return topDown(dungeon, 0, 0);
  }
}