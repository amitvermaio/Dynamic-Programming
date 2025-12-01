package SubsetSum;

public class PartitionKEqualSubsetSum {
  public static void main(String[] args) {
    Solution sol = new Solution();
    int[] nums = {4, 3, 2, 3, 5, 2, 1};
    int k = 4;
    System.out.println(sol.canPartitionKSubsets(nums, k)); // true
  }
}

class Solution {

  public boolean canPartitionKSubsets(int[] nums, int k) {
    int sum = 0;
    for (int x : nums)
      sum += x;

    if (sum % k != 0)
      return false;

    int target = sum / k;
    Arrays.sort(nums);
    int n = nums.length;

    if (nums[n - 1] > target)
      return false;

    boolean[] used = new boolean[n];

    return backtrack(nums, used, k, 0, 0, target);
  }

  static boolean backtrack(int[] nums, boolean[] used, int k, int start, int currSum, int target) {

    // ✔️ all k subsets formed
    if (k == 0)
      return true;

    // ✔️ current subset completed, move to next subset
    if (currSum == target) {
      return backtrack(nums, used, k - 1, 0, 0, target);
    }

    for (int i = start; i < nums.length; i++) {
      if (!used[i] && currSum + nums[i] <= target) {

        used[i] = true;

        if (backtrack(nums, used, k, i + 1, currSum + nums[i], target))
          return true;

        used[i] = false; // backtrack

        // optimization: if element alone cannot start a subset → break
        if (currSum == 0)
          return false;
      }
    }
    return false;
  }
}
