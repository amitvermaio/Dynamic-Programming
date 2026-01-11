import java.util.*;

public class MinimumCostForTickets {
  public static void main(String[] args) {
    Solution sol = new Solution();
    int[] days = { 1, 4, 6, 7, 8, 20 };
    int[] costs = { 2, 7, 15 };
    System.out.println(sol.mincostTickets(days, costs)); // Expected output: 11
  }
}

class Solution {
  static Integer[] dp;

  static int topDown(int curr, int[] days, int[] costs, int n) {
    if (curr >= n)
      return 0;
    if (dp[days[curr]] != null)
      return dp[days[curr]];
    int oneDay = costs[0] + topDown(curr + 1, days, costs, n);
    int sevenDay = costs[1];
    for (int i = curr + 1; i < n; i++) {
      if (days[i] > days[curr] + 6) {
        sevenDay = costs[1] + topDown(i, days, costs, n);
        break;
      }
    }
    int thirtyDay = costs[2];
    for (int i = curr + 1; i < n; i++) {
      if (days[i] > days[curr] + 29) { // currday + next 30 days
        thirtyDay = costs[2] + topDown(i, days, costs, n);
        break; // yha se return nhi kar sakte kyuki aage ka thirtyDay day wala miss ho jayega
               // aur break isliye kyuki ye aage wale number ko bhi ckeck kar lega but hume use
               // check hi nhi karna! hume sirf next trip which is out of 7 days plan hai uspe
               // call karna hai
      }
    }
    return dp[days[curr]] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
  }

  public int bottomUp(int[] days, int[] costs) {
    int n = days.length;
    int[] dp = new int[days[n - 1] + 1];
    Set<Integer> set = new HashSet<>();
    for (int d : days)
      set.add(d);
    for (int i = 1; i <= days[n - 1]; i++) {
      if (!set.contains(i)) {
        dp[i] = dp[i - 1];
        continue;
      }

      int one = costs[0] + dp[max(i - 1, 0)];
      int seven = costs[1] + dp[max(i - 7, 0)];
      int thirty = costs[2] + dp[max(i - 30, 0)];
      dp[i] = min(one, min(seven, thirty));
    }
    return dp[days[n - 1]];
  }

  public int mincostTickets(int[] days, int[] costs) {
    int n = days.length;
    dp = new Integer[days[n - 1] + 1];
    return topDown(0, days, costs, n);
  }
}