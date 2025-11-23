package DP.Knapsack;

public class SubsetSum {
  static Boolean isSubsetSum(int arr[], int sum) {
    int n = arr.length;
    int[][] dp = new int[n + 1][sum + 1];
    for (int i = 1; i <= n; i++) {
      for (int cap = 1; cap <= sum; cap++) {
        int notTake = dp[i - 1][cap];

        int take = 0;
        if (arr[i - 1] <= cap) {
          take = arr[i - 1] + dp[i - 1][cap - arr[i - 1]];
        }

        dp[i][cap] = Math.max(take, notTake);
      }
    }

    return dp[n][sum] == sum;
  }
}

class Solution {

  static Boolean isSubsetSum(int arr[], int sum) {
    int n = arr.length;
    boolean[][] dp = new boolean[n + 1][sum + 1];

    // base case
    for (int i = 0; i <= n; i++) {
      dp[i][0] = true; // sum = 0 → always true
    }

    for (int i = 1; i <= n; i++) {
      for (int cap = 1; cap <= sum; cap++) {

        boolean notTake = dp[i - 1][cap];

        boolean take = false;
        if (arr[i - 1] <= cap) {
          take = dp[i - 1][cap - arr[i - 1]];
        }

        dp[i][cap] = take || notTake;
      }
    }
    return dp[n][sum];
  }
}
