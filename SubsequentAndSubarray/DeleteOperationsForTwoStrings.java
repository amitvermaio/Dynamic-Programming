package DP.SubsequentAndSubarray;

public class DeleteOperationsForTwoStrings {
  public static void main(String[] args) {
    
  }
}

class Solution {
    public int minDistance(String w1, String w2) {
        // insert -> longest common subsequence

        int m = w1.length();
        int n = w2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (w1.charAt(i-1) == w2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int same = dp[m][n];
        int fF = n-same; // from first
        int fS = m-same; // from second
        return fF+fS;
    }
}
