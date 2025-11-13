import java.util.Arrays;

public class PartitionEqualSubsetSum {
  static int[][] dp;

  static int canMake(int[] nums, int c, int n, int i) {
    if (i == n)
      return 0;

    if (dp[i][c] != -1)
      return dp[i][c];
    int skip = canMake(nums, c, n, i + 1);
    if (nums[i] > c)
      return dp[i][c] = skip;
    int pick = nums[i] + canMake(nums, c - nums[i], n, i + 1);
    return dp[i][c] = Math.max(pick, skip);
  }

  static boolean canPartition(int[] nums) {
    int total = Arrays.stream(nums).sum();
    if (total % 2 == 1)
      return false;

    int n = nums.length;
    int capacity = total / 2;
    dp = new int[n][capacity + 1];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }

    int sum = canMake(nums, capacity, n, 0);
    return sum == capacity;
  }

  public static void main(String[] args) {
    int[] nums = {1, 5, 11, 5};
    System.out.println(canPartition(nums));
  }
}
