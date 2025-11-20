public class HouseRobber {
  public int rob(int[] nums) {
    int f = 0;
    int s = 0;
    int res = 0;
    for (int num : nums) {
      res = Math.max(f + num, s);
      f = s;
      s = res;
    }
    return res;
  }

  public int rob2(int[] nums) {
    int n = nums.length;
    if (n == 1)
      return nums[0];
    int[] dp = new int[n];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < n; i++) {
      dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
    }
    return dp[n - 1];
  }

  public static void main(String[] args) {
    HouseRobber hr = new HouseRobber();
    int[] nums = {2, 7, 9, 3, 1};
    System.out.println(hr.rob(nums));  // Output: 12 Optimized Space
    System.out.println(hr.rob2(nums)); // Output: 12
  }
}