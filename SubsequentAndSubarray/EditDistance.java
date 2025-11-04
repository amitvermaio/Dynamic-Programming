package DP.SubsequentAndSubarray;

public class EditDistance {
  
}

class Solution {
    public int minDistance(String w1, String w2) {
        // insert - done
        // delete - done
        // insert - 3rd type problem this is!!!.
        // in this - top-insert, left-delete, diagonal-replace
        int m = w1.length();
        int n = w2.length();
        int[][] dp = new int[m+1][n+1];
        for (int j=1; j<=n; j++) dp[0][j] = j;
        for (int i=1; i<=m; i++) dp[i][0] = i;
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (w1.charAt(i-1) == w2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int num = Math.min(dp[i-1][j], dp[i][j-1]);
                    dp[i][j] = Math.min(num, dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
