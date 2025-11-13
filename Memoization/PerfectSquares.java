package DP.Memoization;

import java.util.Arrays;

public class PerfectSquares {
  static boolean isPerfect(int n) {
    int sqrt = (int) Math.sqrt(n);
    return (sqrt * sqrt == n);
  }

  static int helper(int n, int[] dp) {
    if (isPerfect(n)) return 1;
    if (dp[n] != -1) return dp[n];

    int min = n;
    for (int i=1; i*i<=n; i++) {
      int count = helper(i*i, dp) + helper(n - i*i, dp);
      min = Math.min(min, count);
    }

    dp[n] = min;
    return dp[n];
  }
  
  static int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    return helper(n, dp);
  }

  public static void main(String[] args) {
    int n = 12;
    System.out.println("Minimum number of perfect squares for " + n + " is: " + numSquares(n));
  }
}
