class Solution {
  static final int MOD = 1_000_000_007;

  public int countPartitions(int[] nums, int k) {
    int n = nums.length;
    long[] dp = new long[n + 1];
    dp[0] = 1; // empty prefix ka 1 way

    for (int i = 1; i <= n; i++) {

      int max = nums[i - 1];
      int min = nums[i - 1];

      // try all possible starting points j
      // segment = nums[j-1 ... i-1]
      for (int j = i; j >= 1; j--) {

        // update max/min for segment [j-1 .. i-1]
        max = Math.max(max, nums[j - 1]);
        min = Math.min(min, nums[j - 1]);

        // check condition
        if (max - min > k)
          break;

        // valid segment → add dp[j-1]
        dp[i] = (dp[i] + dp[j - 1]) % MOD;
      }
    }

    return (int) dp[n];
  }
}

// Optimization: Using prefix sums to reduce time complexity to O(n^2) from
// O(n^3)
class SolutionOptimized {
  static final int MOD = 1_000_000_007;

  public int countPartitions(int[] nums, int k) {
    int n = nums.length;

    long[] dp = new long[n];
    long[] pref = new long[n];

    Deque<Integer> maxD = new ArrayDeque<>();
    Deque<Integer> minD = new ArrayDeque<>();

    int L = 0;

    for (int R = 0; R < n; R++) {

      // Maintain max deque
      while (!maxD.isEmpty() && nums[maxD.peekLast()] <= nums[R])
        maxD.pollLast();
      maxD.addLast(R);

      // Maintain min deque
      while (!minD.isEmpty() && nums[minD.peekLast()] >= nums[R])
        minD.pollLast();
      minD.addLast(R);

      // Shrink window until valid
      while (!maxD.isEmpty() && !minD.isEmpty() &&
          nums[maxD.peekFirst()] - nums[minD.peekFirst()] > k) {

        if (maxD.peekFirst() == L)
          maxD.pollFirst();
        if (minD.peekFirst() == L)
          minD.pollFirst();
        L++;
      }

      // Now valid window is [L..R]

      long ways = 0;

      // If L == 0, then we can use dp[0..R-1]
      if (L == 0) {
        // dp[R] = sum(dp[0..R-1]) + 1
        if (R == 0)
          ways = 1; // only one segment [0..0]
        else
          ways = (pref[R - 1] + 1) % MOD;
      } else {
        // dp[L..R] -> sum(dp[L-1 .. R-1])
        long totalRight = (R > 0 ? pref[R - 1] : 0);
        long totalLeft = (L - 2 >= 0 ? pref[L - 2] : 0);
        ways = (totalRight - totalLeft + MOD) % MOD;
      }

      dp[R] = ways;

      // Update prefix sum
      pref[R] = (ways + (R > 0 ? pref[R - 1] : 0)) % MOD;
    }

    return (int) dp[n - 1];
  }
}

public class CountPartitionWithMaxMinDiffAtMostK {
  public static void main(String[] args) {
    Solution sol = new Solution();
    int[] nums = {2, 3, 5, 1, 4};
    int k = 2;
    System.out.println(sol.countPartitions(nums, k)); // Output the result
  }
}