public class O1Knapsack {
  static int knapsack(int[] wt, int[] val, int c) {
    int n = wt.length;
    int[][] dp = new int[n + 1][c + 1];

    // Build dp[][] in bottom-up manner
    for (int i = 1; i <= n; i++) {
      for (int cap = 1; cap <= c; cap++) {
        // If we don't take the item
        int notTake = dp[i - 1][cap];

        // If we take the item (only if fits)
        int take = 0;
        if (wt[i - 1] <= cap) { // i-1 in wt and val array is written because they are 0 based indexed and we are traversing through loop in 1 based indexing.
          take = val[i - 1] + dp[i - 1][cap - wt[i - 1]];
        }

        dp[i][cap] = Math.max(take, notTake);
      }
    }
    return dp[n][c];
  }

  static int knapsackRecursion(int[] wt, int[] val, int c, int i) {
    return 0;
  }

  public static void main(String[] args) {
    int[] val = { 5, 3, 9, 16 };
    int[] wt = { 1, 2, 8, 10 };
    int capacity = 6;
    System.out.println(knapsack(wt, val, capacity));
  }
}
