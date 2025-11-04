package DP.SubsequentAndSubarray;

public class MinimumInsertionStepsToMakeStringPalindrome {
  public static void main(String[] args) {
    
  }
}

class Solution {
    public int minInsertions(String s) {
        int m = s.length();
        int[] dp = new int[m+1];
        for (int i=1; i<=m; i++) {
            int prevDiag = 0;
            for (int j=1; j<=m; j++) {
                int t = dp[j];
                if (s.charAt(i-1) == s.charAt(m-j)) {
                    dp[j] = prevDiag + 1;
                } else {
                    dp[j] = Math.max(t, dp[j-1]);
                }
                prevDiag = t;
            }
        }
        int longest = dp[m];
        return m-longest;
    }
}
