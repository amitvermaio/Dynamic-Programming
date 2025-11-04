package DP.SubsetSum;

public class RodCutting {
  public int cutRod(int[] price) {
    int n = price.length;
    int[] dp = new int[n + 1];
    
    // dp[i] = maximum profit obtainable from a rod of length i
    for (int i = 1; i <= n; i++) {
        for (int j = 0; j < i; j++) {
            // Try cutting a piece of length (j+1)
            // price[j] is the price for length (j+1)
            // dp[i - j - 1] is the optimal solution for remaining length
            dp[i] = Math.max(dp[i], price[j] + dp[i - j - 1]);
        }
    }
    
    return dp[n];
  }
}
