package Knapsack;

public class CombinationsSum4 {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    int target = 4;
    Solution solution = new Solution();
    System.out.println(solution.combinationSum4(nums, target)); // Output: 7
  }
}

class Solution {
  static Integer[] dp;

  static int solve(int[] nums, int target, int i) {
    if (target == 0)
      return 1;
    if (target < 0)
      return 0;

    // Jab index end ho gaya: no more elements
    // if (i == nums.length) return 0;

    // Memoization only on target (i pe depend nahi karta)
    if (dp[target] != null)
      return dp[target];

    // Option 1 → nums[i] ko pick karo (1, 2, 1) -> means har number ke baad shuru
    // se again check karna hoga also 2, 1, 1. That's why we've writted here.
    int pick = solve(nums, target - nums[i], 0);

    // Option 2 → next index par move karo
    int skip = solve(nums, target, i + 1);

    return dp[target] = pick + skip;
  }

  public int combinationSum4(int[] nums, int target) {
    // dp = new Integer[target + 1];
    // return solve(nums, target, 0);
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int i = 1; i <= target; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (i >= nums[j]) {
          dp[i] += dp[i - nums[j]];
        }
      }
    }
    return dp[target];
  }
}
