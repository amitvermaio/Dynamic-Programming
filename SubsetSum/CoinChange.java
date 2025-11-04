package DP.SubsetSum;

import java.util.Arrays;

public class CoinChange {
  public int coinChange(int[] coins, int amount) {
      int[] dp = new int[amount+1];
      int MAX = amount + 1;
      Arrays.fill(dp, MAX);
      dp[0] = 0; // (why not 1? ) for 0 sum we need 0 coins
      for (int i=0; i<coins.length; i++) {
          for (int j=coins[i]; j<=amount; j++) {
              dp[j] = Math.min(dp[j], 1+dp[j-coins[i]]); // It's coz we need minimum coins for amount formation and dp[j] indicated not_pick & dp[j-coins[i]] indicates pick and +1 is coz we are picking one more coins.
          }
      }
      return dp[amount]==MAX ? -1 : dp[amount];
    }

  public static void main(String[] args) {
    int[] coins = {1, 2, 5};
    int amount = 11;
    coinChange(coins, amount);
  }
}
