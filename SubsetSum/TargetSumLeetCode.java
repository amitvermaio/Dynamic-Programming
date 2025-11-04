package DP.SubsetSum;

public class TargetSumLeetCode {
  public int findTargetSumWays(int[] nums, int target) {
        /* with intution of S1 & S2
         * S1 - S2 = target (where S1 is sum and S2 is other sum of unique elems)
         * S1 + S2 = total 
         * if we solve these equations then
         * 2S1 = target + total
         * S1 = (target+total)/2
         * if it exists 
         */
        int total = 0;
        for (int i=0; i<nums.length; i++) {
            total += nums[i];
        }
        int sum = target + total;
        if (sum < 0) return 0;
        if (sum%2 == 1) return 0;
        int[] dp = new int[(sum/2)+1];
        dp[0] = 1;
        for (int i=0; i<nums.length; i++) {
            for (int j=sum/2; j>=nums[i]; j--) {
                dp[j] = dp[j] + dp[j-nums[i]];
            }
        }
        return dp[sum/2];
    }
}
