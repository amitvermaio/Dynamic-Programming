import java.util.*;

public class MinimumCostForTickets {
  public static void main(String[] args) {
    Solution sol = new Solution();
    int[] days = {1, 4, 6, 7, 8, 20};
    int[] costs = {2, 7, 15};
    System.out.println(sol.mincostTickets(days, costs)); // Expected output: 11
  }
}

class Solution {
  static Integer[] dp;

  static int topDown(int currDay, HashSet<Integer> needToTravel, int[] days, int[] costs) {
    if (currDay > dp.length - 1) // Here dp.length - 1 is the last day of travel which is eventually days[d-1] 
      return 0;

    if (!needToTravel.contains(currDay))
      return topDown(currDay + 1, needToTravel, days, costs);

    if (dp[currDay] != null)
      return dp[currDay];

    int oneDay = costs[0] + topDown(currDay + 1, needToTravel, days, costs);
    int sevenDay = costs[1] + topDown(currDay + 7, needToTravel, days, costs);
    int thirtyDay = costs[2] + topDown(currDay + 30, needToTravel, days, costs);
    return dp[currDay] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
  }

  public int bottomUp() {
    return 0;
  }

  public int mincostTickets(int[] days, int[] costs) {
    int d = days.length;
    dp = new Integer[days[d - 1] + 1];
    HashSet<Integer> needToTravel = new HashSet<>();
    for (int day : days)
      needToTravel.add(day);
    return topDown(1, needToTravel, days, costs);
  }
}