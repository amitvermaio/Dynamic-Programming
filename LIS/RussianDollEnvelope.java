package DP.LIS;

public class RussianDollEnvelope {
  public static void main(String[] args) {
    
  }
}

import java.util.*;

class Solution {
    public int maxEnvelopesOptimized(int[][] env) {
        Arrays.sort(env, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1]; // width asc, height desc
            return a[0] - b[0];
        });

        // Extract only heights
        int[] heights = new int[env.length];
        for (int i = 0; i < env.length; i++) {
            heights[i] = env[i][1];
        }

        // LIS on heights using DP + binary search (O(n log n))
        List<Integer> lis = new ArrayList<>();
        for (int h : heights) {
            int idx = Collections.binarySearch(lis, h);
            if (idx < 0) idx = -(idx + 1);
            if (idx == lis.size()) lis.add(h);
            else lis.set(idx, h);
        }

        return lis.size();
    }

    public int maxEnvelopes(int[][] env) {
      int n = env.length;
      Arrays.sort(env, (a, b) -> a[1] - b[1]);
      
      int[] dp = new int[n];
      Arrays.fill(dp, 1);
      for (int i=1; i<n; i++) {
          for (int j=0; j<i; j++) {
              if (env[i][0]>env[j][0] && env[i][1]>env[j][1]) {
                  dp[i] = Math.max(dp[i], dp[j]+1);
              }
          }
      }
      int max = Arrays.stream(dp).max().getAsInt();
      return max;
    }
}

