import java.util.Arrays;

public class New {

  /**
   * Solves the "Burst Balloons" problem (LeetCode 312) using top-down DP with memoization.
   * Given an array of balloon values, it maximizes coins obtained by bursting them optimally.
   *
   * @param nums The original balloon values.
   * @return Maximum coins that can be collected.
   */
  public static int maxCoins(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    // Pad the array with 1 at both ends to simplify multiplication at boundaries.
    int n = nums.length;
    int[] value = new int[n + 2];
    value[0] = 1;
    value[n + 1] = 1;
    System.arraycopy(nums, 0, value, 1, n);

    // memo[left][right] stores best result for open interval (left, right).
    int[][] memo = new int[n + 2][n + 2];

    return dfs(value, memo, 0, n + 1);
  }

  private static int dfs(int[] value, int[][] memo, int left, int right) {
    if (left + 1 >= right) {
      return 0; // No balloon to burst between left and right.
    }

    if (memo[left][right] != 0) {
      return memo[left][right];
    }

    int best = 0;
    // Try each balloon in (left, right) as the last one to burst in this interval.
    for (int mid = left + 1; mid < right; mid++) {
      int coins = value[left] * value[mid] * value[right];
      coins += dfs(value, memo, left, mid);
      coins += dfs(value, memo, mid, right);
      best = Math.max(best, coins);
    }

    memo[left][right] = best;
    return best;
  }

  public static void main(String[] args) {
    int[] balloons = {3, 1, 5, 8};
    int result = maxCoins(balloons);
    System.out.println("Maximum coins: " + result);

    // Additional example to demonstrate memoization benefits.
    int[] harderCase = {9, 76, 64, 21, 97};
    System.out.println("Input: " + Arrays.toString(harderCase));
    System.out.println("Maximum coins: " + maxCoins(harderCase));
  }
}