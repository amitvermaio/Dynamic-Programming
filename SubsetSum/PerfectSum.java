package DP.SubsetSum;

import java.util.Arrays;
// Category || ///\\/\/\/\/\/\/\/\/\/\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
// Only one time -> reverse order traversing n-0, and if we can take multiple times then 0-n;

public class PerfectSum {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3};
    int target = 3;
    int[] dp = new int[target+1];
    dp[0] = 1;
    if (arr[0] <= target) dp[arr[0]] = 1;
    for (int i=1; i<arr.length; i++) {
      for (int j=target; j>=1; j--) {
        if (j-arr[i] >= 0) {
          dp[j] = dp[j] + dp[j-arr[i]];
        }
      }
      System.out.println(Arrays.toString(dp));
    }


    
  }
}

class Solution1 {
    public int perfectSum(int[] nums, int sum) {
        int m = nums.length;
        int n = sum + 1;
        // int[][] dp = new int[m][n];
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i=0; i<m; i++) {
            for (int j=sum; j>=nums[i]; j--) {
                dp[j] += dp[j-nums[i]];
            } 
        }
        return dp[sum];
    }
}

