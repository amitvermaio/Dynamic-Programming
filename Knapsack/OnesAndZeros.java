package Knapsack;

public class OnesAndZeros {
  public static void main(String[] args) {
    String[] strs = { "10", "0001", "111001", "1", "0" };
    int m = 5, n = 3;
    Solution sol = new Solution();
    int result = sol.findMaxForm(strs, m, n);
    System.out.println(result);
  }
}

class Solution {
  static Integer[][][] dp;

  static int knapsack(int[][] freq, int m, int n, int i) {
    if (i == freq.length) {
      return 0;
    }

    if (dp[i][m][n] != null)
      return dp[i][m][n];
    int skip = knapsack(freq, m, n, i + 1);
    if (freq[i][0] > m || freq[i][1] > n)
      return dp[i][m][n] = skip;
    int take = 1 + knapsack(freq, m - freq[i][0], n - freq[i][1], i + 1);
    return dp[i][m][n] = Math.max(skip, take);
  }

  public int findMaxForm(String[] strs, int m, int n) {
    int sz = strs.length;
    int[][] freq = new int[sz][2];
    for (int i = 0; i < sz; i++) {
      String s = strs[i];
      int zero = 0, one = 0;
      for (char ch : s.toCharArray()) {
        if (ch == '0')
          zero++;
        else
          one++;
      }
      freq[i][0] = zero;
      freq[i][1] = one;
    }

    dp = new Integer[sz][m + 1][n + 1];
    return knapsack(freq, m, n, 0);
  }
}
