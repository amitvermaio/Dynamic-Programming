package DP.Knapsack;

public class UnboundedKnapsack {
  static int unboundedKnapsack(int[] wts, int[] vals, int cap, int n) {
    // 0 to n capacity checking 
    // caps in columns and array values in rows
    int[] dp = new int[cap+1];
    dp[0] = 0; // bcoz 0 wt ka 0 element hi hoga
    for (int bagCapacity=1; bagCapacity<=cap; bagCapacity++) {
      int max = 0;
      for (int ele=0; ele<n; ele++) {
        if (wts[ele] <= bagCapacity) {
          int remainingBagCapacity = bagCapacity - wts[ele];
          int remainingBagValue = dp[remainingBagCapacity];
          int totalBagValue = remainingBagValue + vals[ele];

          if (totalBagValue > max) {
            max = totalBagValue;
          }
        }
      }
      dp[bagCapacity] = max;
    }

    return dp[cap];
  }

  public static void main(String[] args) {
    int[] weights = {2, 5, 1, 3, 4};
    int[] values = {15, 14, 10, 45, 30};
    int capacity = 7;
    int n = weights.length;

    int maxValue = unboundedKnapsack(weights, values, capacity, n);
    System.out.println("Maximum value in Unbounded Knapsack = " + maxValue);
  }
}
