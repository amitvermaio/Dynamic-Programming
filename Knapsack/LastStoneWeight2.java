package Knapsack;

import java.util.Arrays;

public class LastStoneWeight2 {
  static int[][] dp;

  static int knapsack(int[] stones, int c, int i) {
    if (i == stones.length) {
      return 0;
    }
    if (dp[i][c] != -1)
      return dp[i][c];
    int skip = knapsack(stones, c, i + 1);
    if (stones[i] > c)
      return dp[i][c] = skip;
    int take = stones[i] + knapsack(stones, c - stones[i], i + 1);
    return dp[i][c] = Math.max(skip, take);
  }

  public int lastStoneWeightII(int[] stones) {
    int total = Arrays.stream(stones).sum();
    dp = new int[stones.length][total / 2 + 1];
    for (int i = 0; i < stones.length; i++) {
      Arrays.fill(dp[i], -1);
    }
    int half = knapsack(stones, total / 2, 0);
    return total - 2 * half;
  }

  public static void main(String[] args) {
    // Almost all problems of knapsack are same, problem is in identifying it. 
  }
}
